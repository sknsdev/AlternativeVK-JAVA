package com.vlasov.alternativevk.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
//import android.widget.BaseAdapter;

import android.widget.Toast;

import com.vlasov.alternativevk.MyApplication;
import com.vlasov.alternativevk.R;
import com.vlasov.alternativevk.common.BaseAdapter;
import com.vlasov.alternativevk.common.utils.VkListHelper;
import com.vlasov.alternativevk.model.WallItem;
import com.vlasov.alternativevk.model.view.BaseViewModel;
import com.vlasov.alternativevk.model.view.NewsFeedItemBody;

import com.vlasov.alternativevk.model.view.NewsItemFooterViewModel;
import com.vlasov.alternativevk.model.view.NewsItemHeaderViewModel;
import com.vlasov.alternativevk.rest.api.WallApi;
import com.vlasov.alternativevk.rest.model.request.WallGetRequestModel;
import com.vlasov.alternativevk.rest.model.response.GetWallResponse;
import com.vlasov.alternativevk.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;


    public NewsFeedFragment() {
        // Required empty public constructor
    }

//----------------------
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getsApplicationComponent().inject(this);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get(new WallGetRequestModel(-181881536).toMap()).enqueue(new Callback<GetWallResponse>() {
            @Override
            public void onResponse(Call<GetWallResponse> call, Response<GetWallResponse> response) {

                //List<NewsFeedItemBody> list = new ArrayList<NewsFeedItemBody>();
                //for (WallItem item : response.body().response.getItems()){
                //    list.add(new NewsFeedItemBody(item));
                List<WallItem> wallItems = VkListHelper.getWallList(response.body().response); //ну и ясен  тут
                List<BaseViewModel> list = new ArrayList<>();

                for (WallItem item : wallItems) {
                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsFeedItemBody(item));
                    list.add(new NewsItemFooterViewModel(item));
                }
                 mAdapter.addItems(list);
              // }
              // mBaseAdapter.addItems(list);
                Toast.makeText(getActivity(), "likes: "+ response.body().response.getItems()
                        .get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<GetWallResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    //-----------------------



    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }


}

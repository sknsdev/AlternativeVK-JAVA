package com.vlasov.alternativevk;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
//import android.widget.BaseAdapter;

import android.widget.Toast;

import com.vlasov.alternativevk.common.BaseAdapter;
import com.vlasov.alternativevk.model.WallItem;
import com.vlasov.alternativevk.model.view.NewsFeedItemBodyViewModel;
import com.vlasov.alternativevk.rest.api.WallApi;
import com.vlasov.alternativevk.rest.model.request.WallGetRequestModel;
import com.vlasov.alternativevk.rest.model.response.WallGetResponse;
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
public class NewsFeedFragment extends BaseFragment {

    @Inject
    WallApi mWallApi;

    RecyclerView mRecyclerView;
    BaseAdapter mBaseAdapter;

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

        mWallApi.get(new WallGetRequestModel(-86529522).toMap()).enqueue(new Callback<WallGetResponse>() {
            @Override
            public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {
                List<NewsFeedItemBodyViewModel> list = new ArrayList<NewsFeedItemBodyViewModel>();
                for (WallItem item : response.body().response.getItems()){
                    list.add(new NewsFeedItemBodyViewModel(item));
                }
                mBaseAdapter.addItems(list);
                Toast.makeText(getActivity(), "likes: "+ response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<WallGetResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    //-----------------------
    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }



    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);

    }


    private void setUpRecyclerView(View rootView){
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    protected void setUpAdapter(RecyclerView recyclerView) {

        mBaseAdapter = new BaseAdapter();

        recyclerView.setAdapter(mBaseAdapter);

    }
}

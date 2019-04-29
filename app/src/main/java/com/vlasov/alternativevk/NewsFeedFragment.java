package com.vlasov.alternativevk;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vlasov.alternativevk.ui.fragment.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFragment {


    public NewsFeedFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }



    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

}

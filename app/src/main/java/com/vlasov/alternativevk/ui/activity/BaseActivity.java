package com.vlasov.alternativevk.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
//import android.widget.Toolbar;


import com.arellomobile.mvp.MvpAppCompatActivity;

import com.vlasov.alternativevk.R;
import com.vlasov.alternativevk.common.manager.MyFragmentManager;
import com.vlasov.alternativevk.ui.fragment.BaseFragment;


public abstract class BaseActivity extends MvpAppCompatActivity {

    MyFragmentManager MyFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);

        MyFragmentManager = new MyFragmentManager();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout parent = findViewById(R.id.main_wrapper);
        getLayoutInflater().inflate(getMainContentLayout(), parent);
    }
    @LayoutRes
    protected abstract int getMainContentLayout();

    public void fragmentOnScreen(BaseFragment fragment){ //Нужен для смены заголовка и видимости кнопки floatingactionbutton
        setToolbarTitle(fragment.createToolbarTitle(this));
    }

    public void setToolbarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    public void setContent(BaseFragment fragment){
        MyFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
    }
    public void addContent(BaseFragment fragment){
        MyFragmentManager.addFragment(this, fragment, R.id.main_wrapper);
    }

    public boolean removeCurrentFragment(){
        return MyFragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment(BaseFragment fragment){
        return MyFragmentManager.removeFragment(this, fragment);
    }

    @Override
    public void onBackPressed(){
        removeCurrentFragment();
    }
}

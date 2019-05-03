package com.vlasov.alternativevk.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vlasov.alternativevk.CurrentUser;
import com.vlasov.alternativevk.MyApplication;
import com.vlasov.alternativevk.ui.fragment.NewsFeedFragment;
import com.vlasov.alternativevk.R;
import com.vlasov.alternativevk.consts.ApiConstants;
import com.vlasov.alternativevk.mvp.presenter.MainPresenter;
import com.vlasov.alternativevk.mvp.view.MainView;

public class MainActivity extends BaseActivity implements MainView {

    //private static final String[] DEFAULT_LOGIN_SCOPE = {};
    @InjectPresenter
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getsApplicationComponent().inject(this);
        //setContentView(R.layout.activity_main);
        Toast.makeText(this, "Access token equal: " + CurrentUser.getAccessToken(),Toast.LENGTH_LONG).show();
        mPresenter.checkAuth();
        //VKSdk.login(this, Arrays.asList(VKScope.WALL, VKScope.PHOTOS));
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                signedId();
            }
            @Override
            public void onError(VKError error) {
                // User didn't pass Authorization
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void startSignIn() {

        VKSdk.login(this, ApiConstants.DEFAULT_LOGIN_SCOPE);

    }

    @Override
    public void signedId() {
        Toast.makeText(this, "Current user id: " + CurrentUser.getId(),Toast.LENGTH_LONG).show();
        setContent(new NewsFeedFragment());

    }

}

package com.vlasov.alternativevk.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vlasov.alternativevk.CurrentUser;
import com.vlasov.alternativevk.mvp.view.MainView;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    public void checkAuth(){
        if (!CurrentUser.isAuthorized()){
            getViewState().startSignIn();
        } else {
            getViewState().signedId();

        }
    }
}

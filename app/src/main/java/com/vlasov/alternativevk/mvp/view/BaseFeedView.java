package com.vlasov.alternativevk.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.vlasov.alternativevk.model.view.BaseViewModel;

import java.util.List;

public interface BaseFeedView extends MvpView {
    void showRefreshing();

    void hideRefreshing();


    void showListProgress();

    void hideListProgress();


    void showError(String message);


    void setItems(List<BaseViewModel> items);

    void addItems(List<BaseViewModel> items);
}
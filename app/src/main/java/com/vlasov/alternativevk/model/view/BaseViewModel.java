package com.vlasov.alternativevk.model.view;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vlasov.alternativevk.R;
import com.vlasov.alternativevk.ui.holder.BaseViewHolder;

public abstract class BaseViewModel {
    public abstract LayoutTypes getType();

    public BaseViewHolder createViewHolder(ViewGroup parent){
        return onCreateViewHolder(LayoutInflater.from(parent.getContext()).inflate(getType().getValue(),parent,false));

    }

    protected abstract BaseViewHolder onCreateViewHolder(View view);

    public enum LayoutTypes {
        NewsFeedItemHeader(R.layout.items_news_header),
        NewsFeedItemBody(R.layout.item_news_body),
        NewsFeedItemFooter(R.layout.item_news_footer);


        private final int id;

        LayoutTypes(int resId) {
            this.id = resId;
        }

        @LayoutRes
        public int getValue() {
            return id;
        }
    }

}

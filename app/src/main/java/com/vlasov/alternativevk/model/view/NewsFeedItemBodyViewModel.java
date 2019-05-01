package com.vlasov.alternativevk.model.view;

import android.view.View;

import com.vlasov.alternativevk.model.WallItem;
import com.vlasov.alternativevk.ui.holder.NewsItemBodyHolder;

public class NewsFeedItemBodyViewModel extends BaseViewModel {
    private int mId;

    private String mText;

    public NewsFeedItemBodyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mText = wallItem.getText();
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    public NewsItemBodyHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }


    public String getText() {
        return mText;
    }

    public int getId() {
        return mId;
    }
}
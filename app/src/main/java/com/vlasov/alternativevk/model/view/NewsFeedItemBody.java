package com.vlasov.alternativevk.model.view;

import android.text.Layout;
import android.view.View;

import com.vlasov.alternativevk.model.WallItem;
import com.vlasov.alternativevk.ui.holder.BaseViewHolder;
import com.vlasov.alternativevk.ui.holder.NewsItemBodyHolder;

public class NewsFeedItemBody extends BaseViewModel {

    private int mId;
    private String mText;

    public NewsFeedItemBody(WallItem wallItem){
        this.mId = wallItem.getId();
        this.mText = wallItem.getText();

    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }


    public int getId() {
        return mId;
    }

    public String getText() {
        return mText;
    }
}

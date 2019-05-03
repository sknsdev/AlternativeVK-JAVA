package com.vlasov.alternativevk.model.view;

import android.text.Layout;
import android.view.View;

import com.vlasov.alternativevk.model.WallItem;
import com.vlasov.alternativevk.ui.holder.BaseViewHolder;
import com.vlasov.alternativevk.ui.holder.NewsItemBodyHolder;

public class NewsFeedItemBody extends BaseViewModel {

    private int mId;
    private String mText;
    private String mAttachmentString;
    private boolean mIsRepost;

    public NewsFeedItemBody(WallItem wallItem){
        this.mId = wallItem.getId();
        this.mText = wallItem.getText();

        if (mIsRepost) {
            this.mText = wallItem.getSharedRepost().getText();
            this.mAttachmentString = wallItem.getSharedRepost().getAttachmentsString();
        } else {
            this.mText = wallItem.getText();
           this.mAttachmentString = wallItem.getAttachmentsString();
        }

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

    public String getmAttachmentString() {
        return mAttachmentString;
    }
}

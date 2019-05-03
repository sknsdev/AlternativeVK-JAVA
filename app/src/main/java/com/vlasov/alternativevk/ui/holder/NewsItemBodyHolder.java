package com.vlasov.alternativevk.ui.holder;


import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.vlasov.alternativevk.MyApplication;
import com.vlasov.alternativevk.R;

import com.vlasov.alternativevk.model.view.NewsFeedItemBody;

import javax.inject.Inject;

public class NewsItemBodyHolder extends BaseViewHolder<NewsFeedItemBody> {

    public TextView mText;
    private TextView tvAttachments;

    @Inject
    protected Typeface mFontGoogle;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        MyApplication.getsApplicationComponent().inject(this);
        mText = (TextView) itemView.findViewById(R.id.tv_text);
        tvAttachments = (TextView) itemView.findViewById(R.id.tv_attachments);

        if (tvAttachments != null) {
            tvAttachments.setTypeface(mFontGoogle);
        }
    }

    @Override
    public void bindViewHolder(NewsFeedItemBody item) {
        mText.setText(item.getText());
        tvAttachments.setText(item.getmAttachmentString());
    }

    @Override
    public void unbindViewHolder() {
        mText.setText(null);
        tvAttachments.setText(null);
    }
}
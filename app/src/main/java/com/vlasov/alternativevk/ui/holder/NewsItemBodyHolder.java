package com.vlasov.alternativevk.ui.holder;


import android.view.View;
import android.widget.TextView;

import com.vlasov.alternativevk.R;
import com.vlasov.alternativevk.model.view.NewsFeedItemBodyViewModel;

public class NewsItemBodyHolder extends BaseViewHolder<NewsFeedItemBodyViewModel> {

    public TextView mText;


    public NewsItemBodyHolder(View itemView) {
        super(itemView);

        mText = (TextView) itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsFeedItemBodyViewModel item) {
        mText.setText(item.getText());
    }

    @Override
    public void unbindViewHolder() {
        mText.setText(null);
    }
}
package com.vlasov.alternativevk.model.view.counter;

import com.vlasov.alternativevk.model.Comments;

public class CommentCounterViewModel  extends CounterViewModel{

    private Comments mComments;

    public CommentCounterViewModel(Comments comments) {
        super(comments.getCount());

        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}

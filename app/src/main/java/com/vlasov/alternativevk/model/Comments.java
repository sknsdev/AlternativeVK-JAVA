
package com.vlasov.alternativevk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Comments  extends RealmObject {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("can_post")
    @Expose
    private Integer canPost;
    @SerializedName("groups_can_post")
    @Expose
    private Boolean groupsCanPost;
    @SerializedName("can_close")
    @Expose
    private Integer canClose;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCanPost() {
        return canPost;
    }

    public void setCanPost(Integer canPost) {
        this.canPost = canPost;
    }

    public Boolean getGroupsCanPost() {
        return groupsCanPost;
    }

    public void setGroupsCanPost(Boolean groupsCanPost) {
        this.groupsCanPost = groupsCanPost;
    }

    public Integer getCanClose() {
        return canClose;
    }

    public void setCanClose(Integer canClose) {
        this.canClose = canClose;
    }

}

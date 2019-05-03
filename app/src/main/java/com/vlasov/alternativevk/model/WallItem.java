
package com.vlasov.alternativevk.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vlasov.alternativevk.model.attachment.apiAttachment;

public class WallItem {
    private String attachmentsString;
    private String senderName;
    private String senderPhoto;


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("from_id")
    @Expose
    private Integer fromId;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("marked_as_ads")
    @Expose
    private Integer markedAsAds;
    @SerializedName("post_type")
    @Expose
    private String postType;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("copy_history")
    @Expose
    private List<WallItem> copyHistory = new ArrayList<>();

    @SerializedName("can_edit")
    @Expose
    private Integer canEdit;
    @SerializedName("created_by")
    @Expose
    private Integer createdBy;
    @SerializedName("can_delete")
    @Expose
    private Integer canDelete;
    @SerializedName("can_pin")
    @Expose
    private Integer canPin;

    @SerializedName("attachments")
    @Expose
    private List<apiAttachment> attachments = new ArrayList<>();
 // @SerializedName("post_source")
 // @Expose
 // private PostSource_ postSource;
    @SerializedName("comments")
    @Expose
    private Comments comments;
    @SerializedName("likes")
    @Expose
    private Likes likes;
    @SerializedName("reposts")
    @Expose
    private Reposts reposts;
    @SerializedName("views")
    @Expose
    private Views views;
    @SerializedName("is_favorite")
    @Expose
    private Boolean isFavorite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getMarkedAsAds() {
        return markedAsAds;
    }

    public void setMarkedAsAds(Integer markedAsAds) {
        this.markedAsAds = markedAsAds;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public List<apiAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<apiAttachment> attachments) {
        this.attachments = attachments;
    }


    // public List<CopyHistory> getCopyHistory() {
   //     return copyHistory;
   // }
//
   // public void setCopyHistory(List<CopyHistory> copyHistory) {
   //     this.copyHistory = copyHistory;
   // }

    public Integer getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Integer canEdit) {
        this.canEdit = canEdit;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Integer canDelete) {
        this.canDelete = canDelete;
    }

    public Integer getCanPin() {
        return canPin;
    }

    public void setCanPin(Integer canPin) {
        this.canPin = canPin;
    }

 //   public PostSource_ getPostSource() {
 //       return postSource;
 //   }
//
 //   public void setPostSource(PostSource_ postSource) {
  //      this.postSource = postSource;
  //  }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public Reposts getReposts() {
        return reposts;
    }

    public void setReposts(Reposts reposts) {
        this.reposts = reposts;
    }

    public Views getViews() {
        return views;
    }

    public void setViews(Views views) {
        this.views = views;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderPhoto() {
        return senderPhoto;
    }


    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setSenderPhoto(String senderPhoto) {
        this.senderPhoto = senderPhoto;
    }

    public boolean haveSharedRepost() {
        return copyHistory.size() > 0;
    }

    public WallItem getSharedRepost() {
        if (haveSharedRepost()) {
            return copyHistory.get(0);
        }
        return null;
    }

    public String getAttachmentsString() {
        return attachmentsString;
    }

    public void setAttachmentsString(String attachmentsString) {
        this.attachmentsString = attachmentsString;
    }
}

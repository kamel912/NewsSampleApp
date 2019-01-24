
package com.teamvii.news.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {

    @SerializedName("id_post")
    @Expose
    private Long idPost;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("category_id")
    @Expose
    private int categoryId;
    @SerializedName("tag")
    @Expose
    private List<Object> tag = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("media")
    @Expose
    private List<PostMedia> postMedia = null;
    @SerializedName("view_count")
    @Expose
    private Long viewCount;
    @SerializedName("like_count")
    @Expose
    private Long likeCount;
    @SerializedName("dislike_count")
    @Expose
    private Long dislikeCount;
    @SerializedName("comment_count")
    @Expose
    private Long commentCount;
    @SerializedName("coutrycode2")
    @Expose
    private String coutrycode2;
    @SerializedName("ranking_score")
    @Expose
    private Long rankingScore;
    @SerializedName("created_at")
    @Expose
    private Long createdAt;

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<Object> getTag() {
        return tag;
    }

    public void setTag(List<Object> tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<PostMedia> getMedia() {
        return postMedia;
    }

    public void setMedia(List<PostMedia> postMedia) {
        this.postMedia = postMedia;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(Long dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public String getCoutrycode2() {
        return coutrycode2;
    }

    public void setCoutrycode2(String coutrycode2) {
        this.coutrycode2 = coutrycode2;
    }

    public Long getRankingScore() {
        return rankingScore;
    }

    public void setRankingScore(Long rankingScore) {
        this.rankingScore = rankingScore;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

}

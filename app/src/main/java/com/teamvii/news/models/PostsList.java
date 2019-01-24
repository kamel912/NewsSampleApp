
package com.teamvii.news.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostsList {

    @SerializedName("meta")
    @Expose
    private PostsMeta postsMeta;
    @SerializedName("posts")
    @Expose
    private List<Post> posts = null;

    public PostsMeta getPostsMeta() {
        return postsMeta;
    }

    public void setPostsMeta(PostsMeta postsMeta) {
        this.postsMeta = postsMeta;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}

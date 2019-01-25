/*
 * Copyright (c) 2019. Team VII By Mohamed Kamel.
 */

package com.teamvii.news.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.teamvii.news.R;
import com.teamvii.news.databinding.PostItem;
import com.teamvii.news.models.Post;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<Post> posts;

    public PostsAdapter() {

    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        PostItem postItem = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.post_item,
                viewGroup,
                false
        );
        return new PostViewHolder(postItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int position) {
        Post post = posts.get(position);
        postViewHolder.postItem.setPost(post);
        postViewHolder.postItem.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (posts == null) {
            return 0;
        } else {
            return posts.size();
        }
    }


    class PostViewHolder extends RecyclerView.ViewHolder {
        PostItem postItem;

        PostViewHolder(PostItem postItem) {
            super(postItem.getRoot());
            this.postItem = postItem;
        }
    }

}

package com.teamvii.news.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.teamvii.news.R;
import com.teamvii.news.models.Post;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_item, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int position) {
        Post post = posts.get(position);
        if (post.getMedia().get(0).getUrl() != null) {
            Picasso.get()
                    .load(post.getMedia().get(0).getUrl())
                    .error(R.drawable.ic_error)
                    .into(postViewHolder.postImage);
        }
        postViewHolder.postCaption.setText(post.getCaption());
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
        @BindView(R.id.postImage)
        ImageView postImage;
        @BindView(R.id.postCaption)
        TextView postCaption;

        PostViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

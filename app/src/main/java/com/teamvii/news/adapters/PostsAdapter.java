package com.teamvii.news.adapters;

import android.content.Context;
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
import com.teamvii.news.utilities.picassoTransformation.CircleTransform;

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
        if (post.getMedia().get(1).getUrl() != null) {
            Picasso.get()
                    .load(post.getMedia().get(0).getUrl())
                    .error(R.drawable.ic_error)
                    .into(postViewHolder.postImage);
        }
        postViewHolder.postCaption.setText(post.getCaption());
        postViewHolder.authorName.setText(post.getName());
        postViewHolder.commentCount.setText(formatCount(post.getCommentCount()));
        postViewHolder.likeCount.setText(formatCount(post.getLikeCount()));

        Picasso.get()
                .load(post.getMedia().get(0).getUrl())
                .transform(new CircleTransform())
                .error(R.drawable.ic_person_black)
                .into(postViewHolder.authorImage);
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
        @BindView(R.id.authorImage)
        ImageView authorImage;
        @BindView(R.id.postCaption)
        TextView postCaption;
        @BindView(R.id.authorName)
        TextView authorName;
        @BindView(R.id.commentCount)
        TextView commentCount;
        @BindView(R.id.likeCount)
        TextView likeCount;

        PostViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private String formatCount(Long count){
        if (count >= 1000)
            return Long.toString(count / 1000) + "K";
        return Long.toString(count);
    }
}

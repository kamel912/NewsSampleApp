/*
 * Copyright (c) 2019. Team VII By Mohamed Kamel.
 */

package com.teamvii.news.fragments;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.teamvii.news.R;
import com.teamvii.news.adapters.PostsAdapter;
import com.teamvii.news.databinding.PostFragment;
import com.teamvii.news.models.Post;
import com.teamvii.news.viewModels.PostsViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostsFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    PostsAdapter postsAdapter;
    int categoryId;
    String title;
    int pageNumber = 1;
    long pagesCount;
    List<Post> posts = new ArrayList<>();
    ProgressBar loading;
    private PostsViewModel postsViewModel;

    public PostsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            categoryId = arguments.getInt(getString(R.string.category_id));
            title = arguments.getString(getString(R.string.category_title));
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        postsViewModel = ViewModelProviders.of(this, viewModelFactory).get(PostsViewModel.class);
        postsViewModel.init(categoryId, pageNumber);
        postsViewModel.getPosts().observe(this, postsList -> {
            if (postsList != null) {
                posts.addAll(postsList.getPosts());
                postsAdapter.setPosts(posts);
                pagesCount = postsList.getPostsMeta().getPages();
                loading.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        PostFragment postFragment = DataBindingUtil.inflate(inflater, R.layout.fragment_posts, container, false);
        postFragment.title.setText(title);
        loading = postFragment.loading;
        postsAdapter = new PostsAdapter();
        postFragment.postsRecycler.setAdapter(postsAdapter);
        postFragment.postsRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (layoutManager != null) {
                    int lastVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
                    if (lastVisibleItemPosition == posts.size() - 1 && pageNumber < pagesCount) {
                        pageNumber++;
                        postsViewModel.loadMore(categoryId, pageNumber);
                        loading.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        return postFragment.getRoot();
    }


}

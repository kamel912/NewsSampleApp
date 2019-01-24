package com.teamvii.news.fragments;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamvii.news.R;
import com.teamvii.news.adapters.PostsAdapter;
import com.teamvii.news.viewModels.PostsViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostsFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private PostsViewModel postsViewModel;

    @BindView(R.id.postsRecycler)
    RecyclerView postsRecycler;

    PostsAdapter postsAdapter;

    int categoryId;

    public PostsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            categoryId = arguments.getInt(getString(R.string.category_id));
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        postsViewModel = ViewModelProviders.of(this, viewModelFactory).get(PostsViewModel.class);
        postsViewModel.init(categoryId, 1);
        postsViewModel.getPosts().observe(this, postsList -> {
            if (postsList != null) {
                postsAdapter.setPosts(postsList.getPosts());
            }
        });

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        ButterKnife.bind(this, view);
        postsAdapter = new PostsAdapter();
        postsRecycler.setAdapter(postsAdapter);
        return view;
    }


}

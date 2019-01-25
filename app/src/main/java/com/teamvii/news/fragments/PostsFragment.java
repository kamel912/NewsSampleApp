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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.teamvii.news.R;
import com.teamvii.news.adapters.PostsAdapter;
import com.teamvii.news.viewModels.PostsViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private PostsViewModel postsViewModel;

    @BindView(R.id.postsRecycler)
    RecyclerView postsRecycler;
    @BindView(R.id.pagesSpinner)
    Spinner pagesSpinner;

    PostsAdapter postsAdapter;

    int categoryId;

    boolean changeSpinnerItems = true;
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
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        postsViewModel = ViewModelProviders.of(this, viewModelFactory).get(PostsViewModel.class);
        postsViewModel.init(categoryId,1);
        postsViewModel.getPosts().observe(this, postsList -> {
            if (postsList != null) {
                postsAdapter.setPosts(postsList.getPosts());
                if (changeSpinnerItems){
                    List<Integer> pages = new ArrayList<>();
                    for (int i = 1; i <= postsList.getPostsMeta().getPages(); i++){
                        pages.add(i);
                    }
                    ArrayAdapter<Integer> pagesAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, pages);
                    pagesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    pagesSpinner.setAdapter(pagesAdapter);
                    changeSpinnerItems = false;
                }
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
        pagesSpinner.setOnItemSelectedListener(this);
        return view;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        postsViewModel.init(categoryId, position + 1);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

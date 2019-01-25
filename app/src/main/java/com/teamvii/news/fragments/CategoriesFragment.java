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
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.teamvii.news.R;
import com.teamvii.news.adapters.CategoriesAdapter;
import com.teamvii.news.databinding.CategoryFragment;
import com.teamvii.news.di.Injectable;
import com.teamvii.news.models.Category;
import com.teamvii.news.viewModels.CategoriesViewModel;

import javax.inject.Inject;

import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment
        implements Injectable, CategoriesAdapter.OnCategoryItemClickedListener {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    RecyclerView categoriesRecycler;
    ProgressBar loading;

    CategoriesAdapter categoriesAdapter;


    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CategoriesViewModel categoriesViewModel = ViewModelProviders.of(this, viewModelFactory).get(CategoriesViewModel.class);
        categoriesViewModel.getCategories().observe(this, categoriesList -> {
            if (categoriesList != null) {
                categoriesAdapter.setCategories(categoriesList.getCategories());
                loading.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        CategoryFragment categoryFragment = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false);
        categoriesRecycler = categoryFragment.categoriesRecycler;
        loading = categoryFragment.loading;
        categoriesAdapter = new CategoriesAdapter(this);
        categoriesRecycler.setAdapter(categoriesAdapter);
        categoriesRecycler.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        return categoryFragment.getRoot();
    }

    @Override
    public void onCategoryItemClicked(Category category) {
        Bundle arguments = new Bundle();
        arguments.putInt(getString(R.string.category_id), category.getId());
        arguments.putString(getString(R.string.category_title), category.getName());
        Navigation.findNavController(categoriesRecycler).navigate(R.id.action_categoriesFragment_to_postsFragment, arguments);
    }
}

package com.teamvii.news.fragments;


import android.arch.lifecycle.Observer;
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
import android.widget.Toast;

import com.teamvii.news.R;
import com.teamvii.news.adapters.CategoriesAdapter;
import com.teamvii.news.models.CategoriesList;
import com.teamvii.news.models.Category;
import com.teamvii.news.viewModels.CategoriesViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment implements CategoriesAdapter.OnCategoryItemClickedListener{

    @Inject
    ViewModelProvider.Factory viewModelFactory;


    private CategoriesViewModel categoriesViewModel;

    @BindView(R.id.categoriesRecycler)
    RecyclerView categoriesRecycler;

    CategoriesAdapter categoriesAdapter;
    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        categoriesViewModel = ViewModelProviders.of(this, viewModelFactory).get(CategoriesViewModel.class);
        categoriesViewModel.getCategories().observe(this, new Observer<CategoriesList>() {
            @Override
            public void onChanged(@Nullable CategoriesList categoriesList) {
                if (categoriesList != null) {
                    categoriesAdapter.setCategories(categoriesList.getCategories());
                }
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        ButterKnife.bind(this, view);
        categoriesAdapter = new CategoriesAdapter(this);
        categoriesRecycler.setAdapter(categoriesAdapter);
        return view;
    }

    @Override
    public void onCategoryItemClicked(Category category) {
        Toast.makeText(getActivity(), String.valueOf(category.getId()), Toast.LENGTH_SHORT).show();
    }
}

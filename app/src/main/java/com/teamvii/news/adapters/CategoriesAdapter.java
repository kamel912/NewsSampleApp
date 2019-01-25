/*
 * Copyright (c) 2019. Team VII By Mohamed Kamel.
 */

package com.teamvii.news.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamvii.news.R;
import com.teamvii.news.databinding.CategoryItem;
import com.teamvii.news.models.Category;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    private List<Category> categories;
    private OnCategoryItemClickedListener listener;

    public CategoriesAdapter(OnCategoryItemClickedListener listener) {
        this.listener = listener;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        CategoryItem categoryItem = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.category_item,
                viewGroup,
                false
        );
        return new CategoryViewHolder(categoryItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        Category category = categories.get(position);
        categoryViewHolder.categoryItem.setCategory(category);
        categoryViewHolder.categoryItem.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (categories == null) {
            return 0;
        } else {
            return categories.size();
        }
    }

    public interface OnCategoryItemClickedListener {
        void onCategoryItemClicked(Category category);
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CategoryItem categoryItem;

        CategoryViewHolder(CategoryItem categoryItem) {
            super(categoryItem.getRoot());
            this.categoryItem = categoryItem;
            categoryItem.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Category category = categories.get(position);
            listener.onCategoryItemClicked(category);
        }
    }
}

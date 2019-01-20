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
import com.teamvii.news.models.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_item, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        Category category = categories.get(position);
        if (category.getImage() != null) {
            Picasso.get()
                    .load(category.getImage())
                    .error(R.drawable.ic_error)
                    .into(categoryViewHolder.categoryImage);
        }
        categoryViewHolder.categoryName.setText(category.getName());
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
        @BindView(R.id.categoryImage)
        ImageView categoryImage;
        @BindView(R.id.categoryName)
        TextView categoryName;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Category category = categories.get(position);
            listener.onCategoryItemClicked(category);
        }
    }
}

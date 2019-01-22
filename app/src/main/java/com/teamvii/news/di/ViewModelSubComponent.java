package com.teamvii.news.di;

import com.teamvii.news.viewModels.CategoriesViewModel;
import com.teamvii.news.viewModels.PostsViewModel;

import dagger.Subcomponent;

/**
 * A sub component to create ViewModels. It is called by the
 * {@link com.teamvii.news.viewModels.CustomViewModelFactory}.
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    CategoriesViewModel categoriesViewModel();
    PostsViewModel postsViewModel();
}

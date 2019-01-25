package com.teamvii.news.di;

import android.arch.lifecycle.ViewModel;

import com.teamvii.news.viewModels.CategoriesViewModel;
import com.teamvii.news.viewModels.PostsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CategoriesViewModel.class)
    abstract ViewModel bindCategoriesViewModel(CategoriesViewModel categoriesViewModel);@Binds

    @IntoMap
    @ViewModelKey(PostsViewModel.class)
    abstract ViewModel bindPostsViewModel(PostsViewModel postsViewModel);
}

/*
 * Copyright (c) 2019. Team VII By Mohamed Kamel.
 */

package com.teamvii.news.di;

import com.teamvii.news.fragments.CategoriesFragment;
import com.teamvii.news.fragments.PostsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract CategoriesFragment contributeCategoriesFragment();

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();
}

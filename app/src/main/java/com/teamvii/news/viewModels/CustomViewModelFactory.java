/*
 * Copyright (c) 2019. Team VII By Mohamed Kamel.
 */

package com.teamvii.news.viewModels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

//import com.teamvii.news.di.ViewModelSubComponent;

@Singleton
public class CustomViewModelFactory implements ViewModelProvider.Factory {
    //    private final ArrayMap<Class, Callable<? extends ViewModel>> creators;
//
//    @Inject
//    public CustomViewModelFactory(ViewModelSubComponent viewModelSubComponent) {
//        creators = new ArrayMap<>();
//
//        // View models cannot be injected directly because they won't be bound to the owner's view model scope.
//        creators.put(CategoriesViewModel.class, viewModelSubComponent::categoriesViewModel);
//        creators.put(PostsViewModel.class, viewModelSubComponent::postsViewModel);
//    }
//
//    @Override
//    public <T extends ViewModel> T create(Class<T> modelClass) {
//        Callable<? extends ViewModel> creator = creators.get(modelClass);
//        if (creator == null) {
//            for (Map.Entry<Class, Callable<? extends ViewModel>> entry : creators.entrySet()) {
//                if (modelClass.isAssignableFrom(entry.getKey())) {
//                    creator = entry.getValue();
//                    break;
//                }
//            }
//        }
//        if (creator == null) {
//            throw new IllegalArgumentException("Unknown model class " + modelClass);
//        }
//        try {
//            return (T) creator.call();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @Inject
    public CustomViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        this.creators = creators;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<? extends ViewModel> creator = creators.get(modelClass);
        if (creator == null) {
            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }
        try {
            return (T) creator.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
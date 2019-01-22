package com.teamvii.news.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.teamvii.news.models.CategoriesList;
import com.teamvii.news.repositories.CategoriesRepository;

import javax.inject.Inject;

public class CategoriesViewModel extends ViewModel {

    private LiveData<CategoriesList> categories;
    private CategoriesRepository repository;

    @Inject
    CategoriesViewModel(CategoriesRepository repository) {
        this.repository = repository;
        categories = this.repository.getCategories();
    }

    public LiveData<CategoriesList> getCategories() {
        return categories;
    }
}

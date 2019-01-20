package com.teamvii.news.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.teamvii.news.models.CategoriesList;
import com.teamvii.news.network.ApiService;
import com.teamvii.news.utilities.NetworkUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.teamvii.news.network.ApiKeys.APP_ID;
import static com.teamvii.news.network.ApiKeys.APP_SECRET;

@Singleton
public class CategoriesRepository {
    private ApiService apiService;

    @Inject
    public CategoriesRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public LiveData<CategoriesList> getCategories() {
        final MutableLiveData<CategoriesList> data = new MutableLiveData<>();
        apiService.getCategories(APP_ID, APP_SECRET, NetworkUtils.getSignature()).enqueue(new Callback<CategoriesList>() {
            @Override
            public void onResponse(@NonNull Call<CategoriesList> call, @NonNull Response<CategoriesList> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<CategoriesList> call, @NonNull Throwable throwable) {
                Log.e("Repo", throwable.getLocalizedMessage());
            }
        });
        return data;
    }
}

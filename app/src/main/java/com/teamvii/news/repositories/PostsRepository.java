package com.teamvii.news.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.teamvii.news.models.PostsList;
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
public class PostsRepository {
    private ApiService apiService;
    private final String SORT_TYPE = "recent";
    private final int PAGE_LIMIT = 10;

    @Inject
    PostsRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public LiveData<PostsList> getPosts(int categoryId, int pageNumber) {
        final MutableLiveData<PostsList> data = new MutableLiveData<>();
        apiService.getPosts(categoryId, SORT_TYPE, pageNumber, PAGE_LIMIT, APP_ID, APP_SECRET, NetworkUtils.getSignature(
                String.valueOf(categoryId),
                SORT_TYPE,
                String.valueOf(pageNumber),
                String.valueOf(PAGE_LIMIT)
        )).enqueue(new Callback<PostsList>() {
            @Override
            public void onResponse(@NonNull Call<PostsList> call, @NonNull Response<PostsList> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<PostsList> call, @NonNull Throwable throwable) {
                Log.e("Repo", throwable.getLocalizedMessage());
            }
        });
        return data;
    }
}

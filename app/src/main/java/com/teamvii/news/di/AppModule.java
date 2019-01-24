package com.teamvii.news.di;

import android.arch.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.teamvii.news.network.ApiKeys;
import com.teamvii.news.network.ApiService;
import com.teamvii.news.viewModels.CustomViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = {ViewModelSubComponent.class})
class AppModule {

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    ApiService provideService(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(ApiKeys.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiService.class);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new CustomViewModelFactory(viewModelSubComponent.build());
    }


}

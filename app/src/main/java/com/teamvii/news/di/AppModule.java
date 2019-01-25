package com.teamvii.news.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.teamvii.news.network.ApiKeys;
import com.teamvii.news.network.ApiService;
import com.teamvii.news.viewModels.CustomViewModelFactory;
import com.teamvii.news.viewModels.PostsViewModel;

import java.util.Map;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {ViewModelModule.class})
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

//    @Singleton
//    @Provides
//    ViewModelProvider.Factory provideViewModelFactory(
//            ViewModelModule viewModelSubComponent) {
//
//        return new CustomViewModelFactory(viewModelSubComponent.bindPostsViewModel(PostsViewModel.class));
//    }

    @Provides
    @Singleton
    ViewModelProvider.Factory providesFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        return new CustomViewModelFactory(creators);
    }

}

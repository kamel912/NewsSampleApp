package com.teamvii.news.di;

import android.app.Application;

import com.teamvii.news.NewsApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        MainActivityModule.class
})
public interface AppComponent {
    void inject(NewsApp newsApp);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

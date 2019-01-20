/*
 * Copyright (c) 2018. Marketune Egypt by Mohamed Kamel.
 */

package com.teamvii.news.network;

import com.google.gson.Gson;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {



    private static Gson gson;

    @Inject
    public RetrofitBuilder(Gson gson) {
        RetrofitBuilder.gson = gson;
    }


    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://stg.api.fawasell.com/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiService.class);
    }

    public static ApiService createService() {
        return buildRetrofit();
    }
}

/*
 * Copyright (c) 2019. Team VII By Mohamed Kamel.
 */

package com.teamvii.news.network;

import com.teamvii.news.models.CategoriesList;
import com.teamvii.news.models.PostsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("categories")
    Call<CategoriesList> getCategories(
            @Query(ApiKeys.APP_ID_KEY) String appId,
            @Query(ApiKeys.APP_SECRET_KEY) String appSecret,
            @Query("signature") String signature
    );


    @GET("posts")
    Call<PostsList> getPosts(
            @Query("category") long categoryId,
            @Query("sort") String sortType,
            @Query("page") int pageNumber,
            @Query("limit") int pageLimit,
            @Query(ApiKeys.APP_ID_KEY) String appId,
            @Query(ApiKeys.APP_SECRET_KEY) String appSecret,
            @Query("signature") String signature
    );
}

/*
 * Copyright (c) 2019. Team VII By Mohamed Kamel.
 */

package com.teamvii.news.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesList {

    @SerializedName("meta")
    @Expose
    private CategoriesMeta categoriesMeta;

    @SerializedName("data")
    @Expose
    private List<Category> categories;

    public CategoriesMeta getCategoriesMeta() {
        return categoriesMeta;
    }

    public void setCategoriesMeta(CategoriesMeta categoriesMeta) {
        this.categoriesMeta = categoriesMeta;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}

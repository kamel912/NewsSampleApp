/*
 * Copyright (c) 2019. Team VII By Mohamed Kamel.
 */

package com.teamvii.news.adapters;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.teamvii.news.R;
import com.teamvii.news.utilities.picassoTransformation.CircleTransform;

public class CustomBindingAdapter {
    @BindingAdapter({"bind:modelImage"})
    public static void loadImage(ImageView imageView, String image) {
        Picasso.get()
                .load(image)
                .error(R.drawable.ic_error)
                .into(imageView);
    }

    @BindingAdapter({"bind:authorImage"})
    public static void loadAuthorImage(ImageView imageView, String image) {
        Picasso.get()
                .load(image)
                .transform(new CircleTransform())
                .error(R.drawable.ic_person_black)
                .into(imageView);

    }

}

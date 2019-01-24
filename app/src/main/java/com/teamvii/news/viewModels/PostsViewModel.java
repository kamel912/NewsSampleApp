package com.teamvii.news.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.teamvii.news.models.PostsList;
import com.teamvii.news.repositories.PostsRepository;

import javax.inject.Inject;

public class PostsViewModel extends ViewModel {
    private LiveData<PostsList> posts;
    private PostsRepository repository;

    @Inject
    PostsViewModel(PostsRepository repository) {
        this.repository = repository;
    }

    public void init(int categoryId, int pageNumber) {
        posts = this.repository.getPosts(categoryId, pageNumber);
    }

    public LiveData<PostsList> getPosts() {
        return posts;
    }
}

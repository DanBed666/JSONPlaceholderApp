package com.example.jsonplaceholderapp;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class PostsViewModel
{
    PostsRepository postsRepository;
    public PostsViewModel()
    {
        postsRepository = new PostsRepository();
    }
    public MutableLiveData<List<Post>> getPostsVm()
    {
        return postsRepository.getPostsRepo();
    }
}

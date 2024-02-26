package com.example.jsonplaceholderapp;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsRepository
{
    public MutableLiveData<List<Post>> getPostsRepo()
    {
        MutableLiveData<List<Post>> mutableLiveData = new MutableLiveData<>();

        RetrofitBuilder.getRetrofitService().getPostsList().enqueue(new Callback<List<Post>>()
        {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response)
            {
                Log.i("REPO", "działa");
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t)
            {
                Log.i("REPO", Objects.requireNonNull(t.getMessage()));
            }
        });

        return mutableLiveData;
    }

    public MutableLiveData<List<Comment>> getCommentsRepo(int postId)
    {
        MutableLiveData<List<Comment>> mutableLiveData = new MutableLiveData<>();

        RetrofitBuilder.getRetrofitService().getCommentsList(postId).enqueue(new Callback<List<Comment>>()
        {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response)
            {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t)
            {

            }
        });

        return mutableLiveData;
    }
}

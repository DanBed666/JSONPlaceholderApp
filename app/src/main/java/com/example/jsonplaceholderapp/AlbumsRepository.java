package com.example.jsonplaceholderapp;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsRepository
{
    public MutableLiveData<List<Album>> getAlbumsRepo()
    {
        MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();

        RetrofitBuilder.getRetrofitService().getAlbumsList().enqueue(new Callback<List<Album>>()
        {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response)
            {
                Log.i("REPO", "działa");
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t)
            {
                Log.i("REPO", Objects.requireNonNull(t.getMessage()));
            }
        });

        return mutableLiveData;
    }
}

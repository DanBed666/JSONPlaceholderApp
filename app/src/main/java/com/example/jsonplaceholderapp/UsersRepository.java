package com.example.jsonplaceholderapp;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepository
{
    public MutableLiveData<User> getUsersRepo(int userId)
    {
        MutableLiveData<User> mutableLiveData = new MutableLiveData<>();

        RetrofitBuilder.getRetrofitService().getUser(userId).enqueue(new Callback<User>()
        {
            @Override
            public void onResponse(Call<User> call, Response<User> response)
            {
                assert response.body() != null;
                Log.i("LOL", response.body().getUsername());
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t)
            {
                Log.e("ERROR", Objects.requireNonNull(t.getMessage()));
            }
        });

        return mutableLiveData;
    }
}

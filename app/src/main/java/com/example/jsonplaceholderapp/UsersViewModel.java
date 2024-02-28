package com.example.jsonplaceholderapp;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class UsersViewModel
{
    UsersRepository usersRepository;
    public UsersViewModel()
    {
        usersRepository = new UsersRepository();
    }
    public MutableLiveData<User> getUserVm(int userId)
    {
        return usersRepository.getUsersRepo(userId);
    }
}

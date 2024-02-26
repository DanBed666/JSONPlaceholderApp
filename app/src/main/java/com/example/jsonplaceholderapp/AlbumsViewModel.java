package com.example.jsonplaceholderapp;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class AlbumsViewModel
{
    AlbumsRepository albumsRepository;
    public AlbumsViewModel()
    {
        albumsRepository = new AlbumsRepository();
    }
    public MutableLiveData<List<Album>> getAlbumsVm()
    {
        return albumsRepository.getAlbumsRepo();
    }
    public MutableLiveData<List<Photo>> getPhotosVm(int albumId)
    {
        return albumsRepository.getPhotosRepo(albumId);
    }
}

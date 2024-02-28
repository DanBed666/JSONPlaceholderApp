package com.example.jsonplaceholderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;
import java.util.Objects;

public class PhotosActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    AlbumsViewModel albumsViewModel;
    PhotosAdapter photosAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(Objects.requireNonNull(getDrawable(R.drawable.divider)));
        recyclerView.addItemDecoration(dividerItemDecoration);

        albumsViewModel = new AlbumsViewModel();

        int albumId = getIntent().getIntExtra("ALBUM_ID", -1);

        getPhotos(albumId);
    }

    public void getPhotos(int albumId)
    {
        albumsViewModel.getPhotosVm(albumId).observeForever(new Observer<List<Photo>>()
        {
            @Override
            public void onChanged(List<Photo> photos)
            {
                photosAdapter = new PhotosAdapter(getApplicationContext(), photos);
                recyclerView.setAdapter(photosAdapter);
                photosAdapter.notifyDataSetChanged();
            }
        });
    }
}
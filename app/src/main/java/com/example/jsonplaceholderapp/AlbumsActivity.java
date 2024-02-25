package com.example.jsonplaceholderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.List;
import java.util.Objects;

public class AlbumsActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    AlbumsViewModel albumsViewModel;
    AlbumsAdapter albumsAdapter;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        recyclerView = findViewById(R.id.recyclerViewAlbums);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(Objects.requireNonNull(getDrawable(R.drawable.divider)));
        recyclerView.addItemDecoration(dividerItemDecoration);

        albumsViewModel = new AlbumsViewModel();

        getAlbums();
    }

    public void getAlbums()
    {
        albumsViewModel.getAlbumsVm().observeForever(new Observer<List<Album>>()
        {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(List<Album> albums)
            {
                albumsAdapter = new AlbumsAdapter(albums, getApplicationContext());
                recyclerView.setAdapter(albumsAdapter);
                albumsAdapter.notifyDataSetChanged();
            }
        });
    }
}
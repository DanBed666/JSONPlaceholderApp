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

public class PostsActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    PostsViewModel postsViewModel;
    PostsAdapter postsAdapter;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(Objects.requireNonNull(getDrawable(R.drawable.divider)));
        recyclerView.addItemDecoration(dividerItemDecoration);

        postsViewModel = new PostsViewModel();

        getPosts();
    }

    public void getPosts()
    {
        postsViewModel.getPostsVm().observeForever(new Observer<List<Post>>()
        {
            @Override
            public void onChanged(List<Post> posts)
            {
                postsAdapter = new PostsAdapter(getApplicationContext(), posts);
                recyclerView.setAdapter(postsAdapter);
                postsAdapter.notifyDataSetChanged();
            }
        });
    }
}
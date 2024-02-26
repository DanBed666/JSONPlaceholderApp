package com.example.jsonplaceholderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;
import java.util.Objects;

public class CommentsActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    PostsViewModel postsViewModel;
    CommentsAdapter commentsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(Objects.requireNonNull(getDrawable(R.drawable.divider)));
        recyclerView.addItemDecoration(dividerItemDecoration);

        postsViewModel = new PostsViewModel();

        int postId = getIntent().getIntExtra("POST_ID", -1);

        getComments(postId);
    }

    public void getComments(int postId)
    {
        postsViewModel.getCommentsVm(postId).observeForever(new Observer<List<Comment>>()
        {
            @Override
            public void onChanged(List<Comment> comments)
            {
                commentsAdapter = new CommentsAdapter(getApplicationContext(), comments);
                recyclerView.setAdapter(commentsAdapter);
                commentsAdapter.notifyDataSetChanged();
            }
        });
    }
}
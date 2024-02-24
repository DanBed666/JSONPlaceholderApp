package com.example.jsonplaceholderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomepageActivity extends AppCompatActivity
{
    FirebaseAuth mAuth;
    Button posts;
    Button albums;
    Button todos;
    Button my_profile;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        mAuth = FirebaseAuth.getInstance();
        posts = findViewById(R.id.btn_posts);
        albums = findViewById(R.id.btn_albums);
        todos = findViewById(R.id.btn_todos);
        my_profile = findViewById(R.id.btn_myprofile);
        logout = findViewById(R.id.btn_logout);

        logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}
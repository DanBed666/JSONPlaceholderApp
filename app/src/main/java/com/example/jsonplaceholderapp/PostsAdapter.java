package com.example.jsonplaceholderapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder>
{
    Context context;
    List<Post> postsList;
    UsersViewModel usersViewModel;
    public PostsAdapter(Context c, List<Post> posts)
    {
        context = c;
        postsList = posts;
        usersViewModel = new UsersViewModel();
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.single_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.title.setText(postsList.get(position).getTitle());
        holder.content.setText(postsList.get(position).getBody());

        usersViewModel.getUserVm(postsList.get(position).getUserId()).observeForever(new Observer<User>()
        {
            @Override
            public void onChanged(User user)
            {
                Log.i("DUPA", String.valueOf(user));
                holder.user.setText(user.getUsername());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, CommentsActivity.class);
                int postId = postsList.get(position).getId();
                intent.putExtra("POST_ID", postId);
                Log.i("ID", String.valueOf(postId));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return postsList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder
    {
        TextView user;
        TextView title;
        TextView content;
        public PostViewHolder(@NonNull View itemView)
        {
            super(itemView);

            user = itemView.findViewById(R.id.tv_user);
            title = itemView.findViewById(R.id.tv_title);
            content = itemView.findViewById(R.id.tv_content);
        }
    }
}

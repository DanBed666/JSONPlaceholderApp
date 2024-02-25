package com.example.jsonplaceholderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder>
{
    Context context;
    List<Post> postsList;
    public PostsAdapter(Context c, List<Post> posts)
    {
        context = c;
        postsList = posts;
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.single_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position)
    {
        holder.title.setText(postsList.get(position).getTitle());
        holder.content.setText(postsList.get(position).getBody());
    }

    @Override
    public int getItemCount()
    {
        return postsList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        TextView content;
        public PostViewHolder(@NonNull View itemView)
        {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title);
            content = itemView.findViewById(R.id.tv_content);
        }
    }
}

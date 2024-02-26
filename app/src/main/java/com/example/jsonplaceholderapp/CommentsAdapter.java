package com.example.jsonplaceholderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>
{
    Context context;
    List<Comment> commentList;
    public CommentsAdapter(Context c, List<Comment> coms)
    {
        context = c;
        commentList = coms;
    }

    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.single_comment, parent, false);
        return new CommentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position)
    {
        holder.title.setText(commentList.get(position).getName());
        holder.email.setText(commentList.get(position).getEmail());
        holder.content.setText(commentList.get(position).getBody());
    }

    @Override
    public int getItemCount()
    {
        return commentList.size();
    }

    public static class CommentsViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        TextView email;
        TextView content;
        public CommentsViewHolder(@NonNull View itemView)
        {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title);
            email = itemView.findViewById(R.id.tv_email);
            content = itemView.findViewById(R.id.tv_content);
        }
    }
}

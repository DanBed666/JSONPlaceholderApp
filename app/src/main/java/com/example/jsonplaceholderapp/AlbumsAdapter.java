package com.example.jsonplaceholderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>
{
    List<Album> albumsList;
    Context context;
    public AlbumsAdapter(List<Album> a, Context c)
    {
        albumsList = a;
        context = c;
    }

    @NonNull
    @Override
    public AlbumsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.single_album, parent, false);
        return new AlbumsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsViewHolder holder, int position)
    {
        holder.title.setText(albumsList.get(position).getTitle());
    }

    @Override
    public int getItemCount()
    {
        return albumsList.size();
    }

    public static class AlbumsViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        public AlbumsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
        }
    }
}

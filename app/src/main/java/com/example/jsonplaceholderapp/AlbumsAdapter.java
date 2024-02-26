package com.example.jsonplaceholderapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
    public void onBindViewHolder(@NonNull AlbumsViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.title.setText(albumsList.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(context, PhotosActivity.class);
                int albumId = albumsList.get(position).getId();
                intent.putExtra("ALBUM_ID", albumId);
                context.startActivity(intent);
            }
        });
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

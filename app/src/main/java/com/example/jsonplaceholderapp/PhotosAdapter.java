package com.example.jsonplaceholderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>
{
    Context context;
    List<Photo> photosList;
    public PhotosAdapter(Context c, List<Photo> p)
    {
        context = c;
        photosList = p;
    }

    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.single_photo, parent, false);
        return new PhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosViewHolder holder, int position)
    {
        holder.title.setText(photosList.get(position).getTitle());
        Picasso.get().load(photosList.get(position).getUrl()).resize(150, 150).into(holder.imageView);
    }

    @Override
    public int getItemCount()
    {
        return photosList.size();
    }

    public static class PhotosViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView imageView;
        public PhotosViewHolder(@NonNull View itemView)
        {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv_photo);
        }
    }
}

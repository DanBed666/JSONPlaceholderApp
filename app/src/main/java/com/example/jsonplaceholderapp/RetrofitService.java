package com.example.jsonplaceholderapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService
{
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<Post>> getPostsList();

    @GET("albums")
    Call<List<Album>> getAlbumsList();

    @GET("posts/{postId}/comments")
    Call<List<Comment>> getCommentsList(@Path("postId") int postId);

    @GET("albums/{albumId}/photos")
    Call<List<Photo>> getPhotosList(@Path("albumId") int albumId);

    @GET("user/{id}")
    Call<User> getUser(@Path("id") int id);
}

package com.example.mvvm_retrofit_recy.api;

import com.example.mvvm_retrofit_recy.models.Post;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonCalls {

    @GET("posts")
    Call<List<Post>> getPosts();
}

package com.example.mvvm_retrofit_recy.repositories;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.mvvm_retrofit_recy.api.JsonCalls;
import com.example.mvvm_retrofit_recy.api.RetrofitBuilder;
import com.example.mvvm_retrofit_recy.models.Post;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostRepository {

    //private static PostRepository instance;
    private static final String TAG = "PostRepository";
    private  MutableLiveData<List<Post>> posts;
    private Context mContext;

    public PostRepository(Application application){
        mContext = application.getApplicationContext();
    }

//    public static PostRepository getInstance(){
//        if(instance == null){
//            instance = new PostRepository();
//        }
//        return instance;
//    }

    public LiveData<List<Post>> getPosts(){
        Retrofit retrofit;
        retrofit = RetrofitBuilder.getRetrofitInstance();
        posts = new MutableLiveData<>();


        JsonCalls jsonCalls = retrofit.create(JsonCalls.class);
        Call<List<Post>> call = jsonCalls.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(mContext, "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                posts.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call,@NonNull Throwable t) {
                Log.e(TAG, "onFailure: "+t );
                Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return posts;
    }
}

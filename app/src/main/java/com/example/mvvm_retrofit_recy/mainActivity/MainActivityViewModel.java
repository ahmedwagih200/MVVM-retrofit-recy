package com.example.mvvm_retrofit_recy.mainActivity;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.mvvm_retrofit_recy.models.Post;
import com.example.mvvm_retrofit_recy.repositories.PostRepository;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<List<Post>> posts;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
       PostRepository postRepository = new PostRepository(application);
        posts = postRepository.getPosts();

    }

//    public void init(){
//        if(posts != null){
//            return;
//        }
//        PostRepository mRepo = PostRepository.getInstance();
//        posts = mRepo.getPosts();
//    }

    LiveData<List<Post>> getPosts(){
        return posts;
    }
}


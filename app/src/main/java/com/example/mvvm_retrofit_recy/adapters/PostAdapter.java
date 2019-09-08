package com.example.mvvm_retrofit_recy.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvvm_retrofit_recy.R;
import com.example.mvvm_retrofit_recy.models.Post;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Post> mposts ;

//    public PostAdapter(List<Post> posts){
//
//        mposts = posts;
//
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Post cPost = mposts.get(position);
        ((ViewHolder)holder).mID.setText(cPost.getId().toString());
    }

    @Override
    public int getItemCount() {
        if(mposts != null)
            return mposts.size();
        else
            return 0;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mID;
        private ViewHolder(@NonNull View itemView){
            super(itemView);
            mID = itemView.findViewById(R.id.id);
        }
    }

    public void setPosts(List<Post> posts) {
        this.mposts = posts;
        notifyDataSetChanged();
    }
}

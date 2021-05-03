package com.intern.chefguru.views.adapter.smoothy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.chefguru.R;
import com.intern.chefguru.model.RecipeModel;

import java.util.ArrayList;

public class SmoothyAllAdapter extends RecyclerView.Adapter<SmoothyAllAdapter.SmoothyAllViewHolder> {

    ArrayList<RecipeModel> SmoothyAll;

    public SmoothyAllAdapter(ArrayList<RecipeModel> smoothyAll) {
        SmoothyAll = smoothyAll;
    }

    @NonNull
    @Override
    public SmoothyAllAdapter.SmoothyAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.smoothyall, parent, false);
        SmoothyAllAdapter.SmoothyAllViewHolder smoothyAllViewHolder = new SmoothyAllAdapter.SmoothyAllViewHolder(view);
        return smoothyAllViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SmoothyAllAdapter.SmoothyAllViewHolder holder, int position) {

        RecipeModel RecipeModel = SmoothyAll.get(position);

        holder.image.setImageResource(RecipeModel.getImage());
        holder.title.setText(RecipeModel.getTitle());
        holder.rate.setRating(RecipeModel.getRate());
        holder.desc.setText(RecipeModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return SmoothyAll.size();
    }

    public static class SmoothyAllViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;

        public SmoothyAllViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.all_img);
            title = itemView.findViewById(R.id.all_title);
            desc = itemView.findViewById(R.id.all_desc);
            rate = itemView.findViewById(R.id.all_rate);
        }
    }
}


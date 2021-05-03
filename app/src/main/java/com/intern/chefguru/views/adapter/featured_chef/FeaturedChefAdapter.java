package com.intern.chefguru.views.adapter.featured_chef;

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

public class FeaturedChefAdapter extends RecyclerView.Adapter<FeaturedChefAdapter.FeaturedChefViewHolder> {

    ArrayList<RecipeModel> FeaturedChef;

    public FeaturedChefAdapter(ArrayList<RecipeModel> featuredChef) {
        FeaturedChef = featuredChef;
    }

    @NonNull
    @Override
    public FeaturedChefViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_chef_design, parent, false);
        FeaturedChefViewHolder featuredChefViewHolder = new FeaturedChefViewHolder(view);
        return featuredChefViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedChefViewHolder holder, int position) {

        RecipeModel RecipeModel = FeaturedChef.get(position);

        holder.image.setImageResource(RecipeModel.getImage());
        holder.title.setText(RecipeModel.getTitle());
        holder.rate.setRating(RecipeModel.getRate());
        holder.desc.setText(RecipeModel.getDescription());


    }

    @Override
    public int getItemCount() {
        return FeaturedChef.size();
    }

    public static class FeaturedChefViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;

        public FeaturedChefViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.chef_img);
            title = itemView.findViewById(R.id.chef_name);
            desc = itemView.findViewById(R.id.chef_detail);
            rate = itemView.findViewById(R.id.chef_rate);
        }
    }
}

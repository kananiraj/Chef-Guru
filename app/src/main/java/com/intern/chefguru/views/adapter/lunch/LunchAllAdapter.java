package com.intern.chefguru.views.adapter.lunch;

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

public class LunchAllAdapter extends RecyclerView.Adapter<LunchAllAdapter.LunchAllViewHolder> {

    ArrayList<RecipeModel> LunchAll;

    public LunchAllAdapter(ArrayList<RecipeModel> lunchAll) {
        LunchAll = lunchAll;
    }

    @NonNull
    @Override
    public LunchAllAdapter.LunchAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lunchall, parent, false);
        LunchAllAdapter.LunchAllViewHolder lunchAllViewHolder = new LunchAllAdapter.LunchAllViewHolder(view);
        return lunchAllViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LunchAllAdapter.LunchAllViewHolder holder, int position) {

        RecipeModel RecipeModel = LunchAll.get(position);

        holder.image.setImageResource(RecipeModel.getImage());
        holder.title.setText(RecipeModel.getTitle());
        holder.rate.setRating(RecipeModel.getRate());
        holder.desc.setText(RecipeModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return LunchAll.size();
    }

    public static class LunchAllViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;

        public LunchAllViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.all_img);
            title = itemView.findViewById(R.id.all_title);
            desc = itemView.findViewById(R.id.all_desc);
            rate = itemView.findViewById(R.id.all_rate);
        }
    }
}


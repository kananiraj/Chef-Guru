package com.example.horizontalview.HelperClasses.ExtendedClass;

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

public class DietFoodAllAdapter extends RecyclerView.Adapter<DietFoodAllAdapter.DietFoodAllViewHolder> {

    ArrayList<RecipeModel> DietFoodAll;

    public DietFoodAllAdapter(ArrayList<RecipeModel> dietFoodAll) {
        DietFoodAll = dietFoodAll;
    }

    @NonNull
    @Override
    public DietFoodAllAdapter.DietFoodAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dietfoodviewall, parent, false);
        DietFoodAllAdapter.DietFoodAllViewHolder dietFoodAllViewHolder = new DietFoodAllAdapter.DietFoodAllViewHolder(view);
        return dietFoodAllViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DietFoodAllAdapter.DietFoodAllViewHolder holder, int position) {

        RecipeModel RecipeModel = DietFoodAll.get(position);

        holder.image.setImageResource(RecipeModel.getImage());
        holder.title.setText(RecipeModel.getTitle());
        holder.rate.setRating(RecipeModel.getRate());
        holder.desc.setText(RecipeModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return DietFoodAll.size();
    }

    public static class DietFoodAllViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;

        public DietFoodAllViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.all_img);
            title = itemView.findViewById(R.id.all_title);
            desc = itemView.findViewById(R.id.all_desc);
            rate = itemView.findViewById(R.id.all_rate);
        }
    }
}


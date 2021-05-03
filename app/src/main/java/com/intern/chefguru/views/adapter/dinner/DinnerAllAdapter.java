package com.intern.chefguru.views.adapter.dinner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.chefguru.R;
import com.intern.chefguru.listeners.RecyclerViewItemClickListener;
import com.intern.chefguru.model.RecipeModel;

import java.util.ArrayList;

public class DinnerAllAdapter extends RecyclerView.Adapter<DinnerAllAdapter.DinnerAllViewHolder> {

    ArrayList<RecipeModel> DinnerAll;

    public DinnerAllAdapter(ArrayList<RecipeModel> DinnerAll) {
        DinnerAll=DinnerAll;
    }


    @NonNull
    @Override
    public DinnerAllAdapter.DinnerAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dinnerall, parent, false);
        DinnerAllAdapter.DinnerAllViewHolder dinnerAllViewHolder = new DinnerAllAdapter.DinnerAllViewHolder(view);
        return dinnerAllViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DinnerAllAdapter.DinnerAllViewHolder holder, int position) {

        final RecipeModel RecipeModel = DinnerAll.get(position);

        holder.image.setImageResource(RecipeModel.getImage());
        holder.title.setText(RecipeModel.getTitle());
        holder.rate.setRating(RecipeModel.getRate());
        holder.desc.setText(RecipeModel.getDescription());



    }

    @Override
    public int getItemCount() {
        return DinnerAll.size();
    }

    public static class DinnerAllViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;
        final View mView;

        public DinnerAllViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.all_img);
            title = itemView.findViewById(R.id.all_title);
            desc = itemView.findViewById(R.id.all_desc);
            rate = itemView.findViewById(R.id.all_rate);
            mView = itemView;
        }
    }
}



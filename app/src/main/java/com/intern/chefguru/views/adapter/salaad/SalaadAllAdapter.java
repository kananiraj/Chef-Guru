package com.intern.chefguru.views.adapter.salaad;

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

public class SalaadAllAdapter extends RecyclerView.Adapter<SalaadAllAdapter.SalaadAllViewHolder> {

    ArrayList<RecipeModel> SalaadAll;

    public SalaadAllAdapter(ArrayList<RecipeModel> salaadAll) {
        SalaadAll = salaadAll;
    }

    @NonNull
    @Override
    public SalaadAllAdapter.SalaadAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.salaadall, parent, false);
        SalaadAllAdapter.SalaadAllViewHolder salaadAllViewHolder = new SalaadAllAdapter.SalaadAllViewHolder(view);
        return salaadAllViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SalaadAllAdapter.SalaadAllViewHolder holder, int position) {

        RecipeModel RecipeModel = SalaadAll.get(position);

        holder.image.setImageResource(RecipeModel.getImage());
        holder.title.setText(RecipeModel.getTitle());
        holder.rate.setRating(RecipeModel.getRate());
        holder.desc.setText(RecipeModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return SalaadAll.size();
    }

    public static class SalaadAllViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;

        public SalaadAllViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.all_img);
            title = itemView.findViewById(R.id.all_title);
            desc = itemView.findViewById(R.id.all_desc);
            rate = itemView.findViewById(R.id.all_rate);
        }
    }
}



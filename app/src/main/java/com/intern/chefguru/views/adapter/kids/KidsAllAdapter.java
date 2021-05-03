package com.intern.chefguru.views.adapter.kids;

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

public class KidsAllAdapter extends RecyclerView.Adapter<KidsAllAdapter.KidsAllViewHolder> {

    ArrayList<RecipeModel> KidsAll;

    public KidsAllAdapter(ArrayList<RecipeModel> kidsAll) {
        KidsAll = kidsAll;
    }

    @NonNull
    @Override
    public KidsAllAdapter.KidsAllViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kidsall, parent, false);
        KidsAllAdapter.KidsAllViewHolder kidsAllViewHolder = new KidsAllAdapter.KidsAllViewHolder(view);
        return kidsAllViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KidsAllAdapter.KidsAllViewHolder holder, int position) {

        RecipeModel RecipeModel = KidsAll.get(position);

        holder.image.setImageResource(RecipeModel.getImage());
        holder.title.setText(RecipeModel.getTitle());
        holder.rate.setRating(RecipeModel.getRate());
        holder.desc.setText(RecipeModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return KidsAll.size();
    }

    public static class KidsAllViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;

        public KidsAllViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.all_img);
            title = itemView.findViewById(R.id.all_title);
            desc = itemView.findViewById(R.id.all_desc);
            rate = itemView.findViewById(R.id.all_rate);
        }
    }
}



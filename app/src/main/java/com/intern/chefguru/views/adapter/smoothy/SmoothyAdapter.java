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
import com.intern.chefguru.listeners.RecyclerViewItemClickListener;
import com.intern.chefguru.model.RecipeModel;

import java.util.ArrayList;

public class SmoothyAdapter extends RecyclerView.Adapter<SmoothyAdapter.SmoothyViewHolder> {

    ArrayList<RecipeModel> Smoothy;
    private final RecyclerViewItemClickListener mListener;


    public SmoothyAdapter(ArrayList<RecipeModel> smoothy, RecyclerViewItemClickListener mListener) {
        Smoothy = smoothy;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public SmoothyAdapter.SmoothyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.smoothy_slider, parent, false);
        SmoothyAdapter.SmoothyViewHolder smoothyViewHolder = new SmoothyAdapter.SmoothyViewHolder(view);
        return smoothyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SmoothyAdapter.SmoothyViewHolder holder, int position) {

        final RecipeModel RecipeModel = Smoothy.get(position);

        holder.image.setImageResource(RecipeModel.getImage());
        holder.title.setText(RecipeModel.getTitle());
        holder.rate.setRating(RecipeModel.getRate());
        holder.desc.setText(RecipeModel.getDescription());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onItemClick(RecipeModel);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return Smoothy.size();
    }

    public static class SmoothyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;
        final View mView;


        public SmoothyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.slider_img);
            title = itemView.findViewById(R.id.slider_title);
            desc = itemView.findViewById(R.id.slider_desc);
            rate = itemView.findViewById(R.id.slider_rate);
            mView = itemView;
        }
    }
}


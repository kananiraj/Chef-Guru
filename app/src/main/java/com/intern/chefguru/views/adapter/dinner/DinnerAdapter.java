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

public class DinnerAdapter extends RecyclerView.Adapter<DinnerAdapter.DinnerViewHolder> {

    ArrayList<RecipeModel> Dinner;
    private final RecyclerViewItemClickListener mListener;


    public DinnerAdapter(ArrayList<RecipeModel> dinner, RecyclerViewItemClickListener mListener) {
        Dinner = dinner;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public DinnerAdapter.DinnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dinner_slider, parent, false);
        DinnerAdapter.DinnerViewHolder dinnerViewHolder = new DinnerAdapter.DinnerViewHolder(view);
        return dinnerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DinnerAdapter.DinnerViewHolder holder, int position) {

        final RecipeModel RecipeModel = Dinner.get(position);

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
        return Dinner.size();
    }

    public static class DinnerViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;
        final View mView;


        public DinnerViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.slider_img);
            title = itemView.findViewById(R.id.slider_title);
            desc = itemView.findViewById(R.id.slider_desc);
            rate = itemView.findViewById(R.id.slider_rate);
            mView = itemView;

        }
    }
}

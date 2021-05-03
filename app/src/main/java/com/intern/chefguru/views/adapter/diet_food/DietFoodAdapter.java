package com.intern.chefguru.views.adapter.diet_food;

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

public class DietFoodAdapter extends RecyclerView.Adapter<DietFoodAdapter.DietFoodViewHolder> {

    ArrayList<RecipeModel> DietFood;
    private final RecyclerViewItemClickListener mListener;

    public DietFoodAdapter(ArrayList<RecipeModel> dietFood, RecyclerViewItemClickListener listener) {
        DietFood = dietFood;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public DietFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dietfood_slider, parent, false);
        DietFoodViewHolder dietFoodViewHolder = new DietFoodViewHolder(view);
        return dietFoodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DietFoodViewHolder holder, int position) {
        final RecipeModel RecipeModel = DietFood.get(position);

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
        return DietFood.size();
    }

    public class DietFoodViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;
        final View mView;

        public DietFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            image = itemView.findViewById(R.id.slider_img);
            title = itemView.findViewById(R.id.slider_title);
            desc = itemView.findViewById(R.id.slider_desc);
            rate = itemView.findViewById(R.id.slider_rate);
        }
    }
}

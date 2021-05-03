package com.intern.chefguru.views.adapter.break_fast;

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

public class BreakFastAdapter extends RecyclerView.Adapter<BreakFastAdapter.BreakFastViewHolder>{

    ArrayList<RecipeModel> BreakFast;
    private final RecyclerViewItemClickListener mListener;


    public BreakFastAdapter(ArrayList<RecipeModel> breakFast, RecyclerViewItemClickListener mListener) {
        BreakFast = breakFast;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public BreakFastAdapter.BreakFastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.breakfast_slider,parent,false);
        BreakFastAdapter.BreakFastViewHolder breakFastViewHolder = new BreakFastAdapter.BreakFastViewHolder(view);
        return breakFastViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BreakFastAdapter.BreakFastViewHolder holder, int position) {

        final RecipeModel RecipeModel = BreakFast.get(position);

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
        return BreakFast.size();
    }

    public static class BreakFastViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,desc;
        RatingBar rate;
        final View mView;

        public BreakFastViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            image = itemView.findViewById(R.id.slider_img);
            title = itemView.findViewById(R.id.slider_title);
            desc = itemView.findViewById(R.id.slider_desc);
            rate = itemView.findViewById(R.id.slider_rate);
        }
    }
}


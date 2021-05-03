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
import com.intern.chefguru.listeners.RecyclerViewItemClickListener;
import com.intern.chefguru.model.RecipeModel;

import java.util.ArrayList;

public class SalaadAdapter extends RecyclerView.Adapter<SalaadAdapter.SalaadViewHolder> {

    ArrayList<RecipeModel> Salaad;
    private final RecyclerViewItemClickListener mListener;


    public SalaadAdapter(ArrayList<RecipeModel> salaad, RecyclerViewItemClickListener mListener) {
        Salaad = salaad;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public SalaadAdapter.SalaadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.salaad_slider, parent, false);
        SalaadAdapter.SalaadViewHolder salaadViewHolder = new SalaadAdapter.SalaadViewHolder(view);
        return salaadViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SalaadAdapter.SalaadViewHolder holder, int position) {

        final RecipeModel RecipeModel = Salaad.get(position);

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
        return Salaad.size();
    }

    public static class SalaadViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;
        final View mView;

        public SalaadViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.slider_img);
            title = itemView.findViewById(R.id.slider_title);
            desc = itemView.findViewById(R.id.slider_desc);
            rate = itemView.findViewById(R.id.slider_rate);
            mView = itemView;
        }
    }
}

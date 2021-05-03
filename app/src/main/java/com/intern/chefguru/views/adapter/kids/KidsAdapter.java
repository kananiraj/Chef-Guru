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
import com.intern.chefguru.listeners.RecyclerViewItemClickListener;
import com.intern.chefguru.model.RecipeModel;

import java.util.ArrayList;

public class KidsAdapter extends RecyclerView.Adapter<KidsAdapter.KidsViewHolder> {

    ArrayList<RecipeModel> Kidsfood;
    private final RecyclerViewItemClickListener mListener;


    public KidsAdapter(ArrayList<RecipeModel> kidsfood, RecyclerViewItemClickListener mListener) {
        Kidsfood = kidsfood;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public KidsAdapter.KidsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kidsfav_slider, parent, false);
        KidsAdapter.KidsViewHolder kidsViewHolder = new KidsAdapter.KidsViewHolder(view);
        return kidsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KidsAdapter.KidsViewHolder holder, int position) {

        final RecipeModel RecipeModel = Kidsfood.get(position);

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
        return Kidsfood.size();
    }

    public static class KidsViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;
        RatingBar rate;
        final View mView;


        public KidsViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.slider_img);
            title = itemView.findViewById(R.id.slider_title);
            desc = itemView.findViewById(R.id.slider_desc);
            rate = itemView.findViewById(R.id.slider_rate);
            mView = itemView;
        }
    }
}


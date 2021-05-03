package com.intern.chefguru.views.adapter.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.intern.chefguru.R;
import com.intern.chefguru.listeners.RecyclerViewItemClickListener;
import com.intern.chefguru.model.CategoryModel;

import java.util.List;

public class CategoryItemRecyclerViewAdapter extends RecyclerView.Adapter<CategoryItemRecyclerViewAdapter.ViewHolder> {

    private final List<CategoryModel> mValues;
    private final RecyclerViewItemClickListener mListener;

    public CategoryItemRecyclerViewAdapter(List<CategoryModel> items, RecyclerViewItemClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mItemTitle.setText(mValues.get(position).getCategoryTitle());
        Glide.with(holder.mView.getContext()).load(holder.mItem.getCategoryImage()).into(holder.mItemImage);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onItemClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mItemTitle;
        final ImageView mItemImage;
        CategoryModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mItemTitle = view.findViewById(R.id.tvItemName);
            mItemImage = view.findViewById(R.id.ivItemImage);
        }
    }
}

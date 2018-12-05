package com.example.tourguide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mayank on 12/5/18 at 9:06 PM
 **/
public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {
    private ArrayList<Interest> mInterest;
    private LayoutInflater mLayoutInflater;
    private int mPageNumber;

    CategoryListAdapter(Context context, int pageNumber) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mPageNumber = pageNumber;
        mInterest = ContentManager.getInstance(context).getInterests(mPageNumber);
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.page_one_list_item, parent, false);

        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bindCategory(mInterest.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mInterest.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.background_image_view)
        ImageView backgroundImageView;
        @BindView(R.id.title_text_view)
        TextView titleTextView;
        @BindView(R.id.description_text_view)
        TextView descriptionTextView;
        @BindView(R.id.favourite_button)
        ImageView favouriteButton;

        CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindCategory(Interest placeToVisit, int position) {
            titleTextView.setText(placeToVisit.getTitle());
            descriptionTextView.setText(placeToVisit.getDescription());
            Drawable imageDrawable = mLayoutInflater.getContext().getResources().getDrawable(placeToVisit.getImageResId());
            backgroundImageView.setImageDrawable(imageDrawable);
            favouriteButton.setImageDrawable(mLayoutInflater.getContext().getDrawable((position % 2 == 0) ? R.drawable.ic_like : R.drawable.ic_liked));

        }
    }
}

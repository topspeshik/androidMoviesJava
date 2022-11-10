package com.example.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>{


    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    private List<Review> reviews = new ArrayList<>();

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false
        );
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
            Review review = reviews.get(position);
            holder.textViewAuthor.setText(review.getAuthor());
            holder.textViewReview.setText(review.getReview());
            String type = review.getType();
            int colorResId = android.R.color.holo_red_light;
            switch (type){
                case "Позитивный":
                    colorResId= android.R.color.holo_green_light;
                    break;
                case "Нейтральный":
                    colorResId = android.R.color.holo_orange_light;
                    break;

            }

            int color = ContextCompat.getColor(holder.itemView.getContext(), colorResId);

            holder.linearLayoutContainer.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout linearLayoutContainer;
        private TextView textViewAuthor;
        private TextView textViewReview;


        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutContainer = itemView.findViewById(R.id.linearLayoutContainer);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewReview = itemView.findViewById(R.id.textViewReview);

        }
    }
}

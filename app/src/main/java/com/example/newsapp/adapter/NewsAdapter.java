package com.example.newsapp.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.models.NewsModel;
import com.example.newsapp.webView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    Context context;
    ArrayList<NewsModel> newsModelArrayList;

    public NewsAdapter(Context context, ArrayList<NewsModel> newsModelArrayList) {
        this.context = context;
        this.newsModelArrayList = newsModelArrayList;
    }



    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        holder.mTime.setText("Published at:- " + newsModelArrayList.get(position).getPublishedAt());
        holder.mAuthor.setText("Author:- " + newsModelArrayList.get(position).getAuthor());
        holder.mHeading.setText(newsModelArrayList.get(position).getTitle());
        holder.mContent.setText(newsModelArrayList.get(position).getDescription());
        Glide.with(context).load(newsModelArrayList.get(position).getUrlToImage()).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return newsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mHeading, mContent, mAuthor, mTime;
        CardView mCard;
        ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeading = itemView.findViewById(R.id.tvMainHeading);
            mContent = itemView.findViewById(R.id.tvContent);
            mAuthor = itemView.findViewById(R.id.tvAuthor);
            mTime = itemView.findViewById(R.id.tvTime);
            mCard = itemView.findViewById(R.id.cardView);
            mImageView = itemView.findViewById(R.id.ivContent);

            mCard.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v == mCard) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(context, webView.class);
                    intent.putExtra("url", newsModelArrayList.get(position).getUrl());
                    context.startActivity(intent);
                }
            }
        }
    }

}

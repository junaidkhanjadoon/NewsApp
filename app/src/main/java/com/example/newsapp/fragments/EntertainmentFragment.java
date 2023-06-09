package com.example.newsapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.adapter.NewsAdapter;
import com.example.newsapp.api.retrofit.ApiUtilities;
import com.example.newsapp.models.MainNewsModel;
import com.example.newsapp.models.NewsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntertainmentFragment extends Fragment {
    String api="f92b6fcda30540a9ab30f99e0758fe1d";
    ArrayList<NewsModel> newsModelArrayList;
    NewsAdapter adapter;
    String country="in";
    private RecyclerView entertainmentRecycler;
    private String category="entertainment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.entertainmentfragment,null);
        entertainmentRecycler=v.findViewById(R.id.entertainmentRecycler);
        newsModelArrayList=new ArrayList<>();
        entertainmentRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new NewsAdapter(getContext(),newsModelArrayList);
        entertainmentRecycler.setAdapter(adapter);


        findNews();
        return v;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<MainNewsModel>() {
            @Override
            public void onResponse(Call<MainNewsModel> call, Response<MainNewsModel> response) {
                if (response.isSuccessful()){
                    newsModelArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNewsModel> call, Throwable t) {

            }
        });
    }
}

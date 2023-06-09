package com.example.newsapp.models;

import java.util.ArrayList;

public class MainNewsModel {
    private String status;
    private String totalResults;
    private ArrayList<NewsModel> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<NewsModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsModel> articles) {
        this.articles = articles;
    }

    public MainNewsModel(String status, String totalResults, ArrayList<NewsModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }
}

package com.example.hyde.pixabayapplicationusingretrofit.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseHits {

    @SerializedName("hits")
    public List<HitsItem> hits;

    @SerializedName("total")
    public int total;

    @SerializedName("totalHits")
    public int totalHits;
}
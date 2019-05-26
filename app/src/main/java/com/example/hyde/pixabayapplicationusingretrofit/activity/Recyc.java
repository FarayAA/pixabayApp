package com.example.hyde.pixabayapplicationusingretrofit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hyde.pixabayapplicationusingretrofit.R;
import com.example.hyde.pixabayapplicationusingretrofit.adapter.NamaAdapter;
import com.example.hyde.pixabayapplicationusingretrofit.api.ApiCall;
import com.example.hyde.pixabayapplicationusingretrofit.api.ApiInterface;
import com.example.hyde.pixabayapplicationusingretrofit.models.HitsItem;
import com.example.hyde.pixabayapplicationusingretrofit.models.ResponseHits;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class Recyc extends AppCompatActivity {
    private TextView textView;
    private RecyclerView recyclerView;
    private NamaAdapter adapter;
    private HitsItem hitsItem;
    private ImageView view;
    String pertama, kedua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyc);


        recyclerView = (RecyclerView) findViewById(R.id.rec);
        textView = (TextView)findViewById(R.id.titlez);
        view = (ImageView) findViewById(R.id.img);

        // Mengambil String dari Intent
        Intent myIntent = getIntent();
        pertama = myIntent.getStringExtra("q");
        kedua = myIntent.getStringExtra("type");

        textView.setText("Image of "+pertama);
        setRecycler("");


    }



    public void setRecycler(String s) {

        ApiInterface apiInterface = ApiCall.getClient().create(ApiInterface.class);
        Call<ResponseHits> responseCall = null;
        if (s.equals("")) {
            responseCall = apiInterface.getLove(pertama, kedua);
        } else {
            responseCall = apiInterface.searc(pertama);
        }
        responseCall.enqueue(new Callback<ResponseHits>() {
            @Override
            public void onResponse(Call<ResponseHits> call, retrofit2.Response<ResponseHits> response) {
               /* String json = new Gson().toJson(response);
                Log.d("JSON", "onResponse: "+json);*/
                if (response.body().hits.size() > 0) {
                    adapter = new NamaAdapter(Recyc.this, response.body().hits);
                    //
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Recyc.this);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());//
                    //adapter
                    recyclerView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<ResponseHits> call, Throwable t) {
                Log.i("autolog", "t: " + t.getMessage());
                Log.i("autolog", "t: " + t.getLocalizedMessage());
            }
        });

    }

    public void onItemClick(HitsItem myData) {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_main, null);

        ImageView image = (ImageView) dialogView.findViewById(R.id.flow);


        Glide.with(this).load(myData.webformatURL)
                .into(image);
        ad.setView(dialogView);
        AlertDialog alertDialog=ad.create();
        alertDialog.show();
    }
}
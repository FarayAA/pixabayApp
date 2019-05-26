package com.example.hyde.pixabayapplicationusingretrofit.api;

import com.example.hyde.pixabayapplicationusingretrofit.models.ResponseHits;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hyde on 22/03/2018.
 */

public interface ApiInterface {
    // Memanggil API
    @GET("?key=8576793-c6e35fb4e82a38d38b45ad59a&q=love&image_type=photo")
    Call<ResponseHits> setHits();

    //Memanggil API dengan Parameternya
    @GET("?key=8576793-c6e35fb4e82a38d38b45ad59a&")
    Call<ResponseHits> getLove(@Query("q") String query, @Query("image_type")String type);

    //Memanggil API dengan menambahkan Parameter
    @POST("?key=8576793-c6e35fb4e82a38d38b45ad59a&")
    Call<ResponseHits> searc(@Query("q") String query);
    //Call<Response> getImages(@QueryMap Map<String, String> parameter);
}

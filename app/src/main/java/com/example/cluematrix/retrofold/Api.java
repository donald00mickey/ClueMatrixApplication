package com.example.cluematrix.retrofold;

import com.example.cluematrix.retrofold.model.ClueResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("api/get")
    Call<ClueResponse> getData();
}

package com.example.jeevesh.myapplication3.retrofit;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebAPI {
    @GET("test")
    Call<com.example.jeevesh.myapplication3.model.Response> getData(@Query("name") String name, @Query("age") String age, @Query("phone") String phone);
}

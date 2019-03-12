package com.example.jeevesh.myapplication3.retrofit;

import android.content.Context;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebAPIHelper {

    private WebAPI webAPI = null;

    public void init(Context context){
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.14/")
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        webAPI = retrofit.create(WebAPI.class);
    }


    public void getData(retrofit2.Callback<com.example.jeevesh.myapplication3.model.Response> responseCallback, String name, String age, String phone) {
        try {
            if (webAPI != null) {
                Call<com.example.jeevesh.myapplication3.model.Response> call = webAPI.getData(name, age, phone);
                call.enqueue(responseCallback);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

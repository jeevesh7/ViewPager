package com.example.jeevesh.myapplication3.model;

import com.google.gson.annotations.SerializedName;

public class Response extends Data{
    private Integer status;
    private String error;
    private Data data;

    public Response(String name, String phone){

        this.name = name;
        this.phone = phone;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}

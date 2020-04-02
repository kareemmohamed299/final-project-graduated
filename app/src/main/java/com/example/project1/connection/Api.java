package com.example.project1.connection;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("api/student")

    public Call<student> getdata(@Body HashMap<Object, Object> map);
}

package com.example.project1.connection;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @POST("api/student")

    public Call<student> getdata(@Body HashMap<Object, Object> map);
    @GET("api/course")
    public Call<cource> courcedata(@Query("code")String code);
}

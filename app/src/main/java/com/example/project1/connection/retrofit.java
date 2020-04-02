package com.example.project1.connection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit {
    private static final String Url="https://kmmmm.000webhostapp.com/";
    private static retrofit INSTANCE;
    public Retrofit r;

    public retrofit()
    {
        r=new Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized retrofit getINSTANCE() {
        if(null==INSTANCE)
        {
            INSTANCE=new retrofit();
        }
        return INSTANCE;
    }
    public Api getApi()
    {
        return  r.create(Api.class);
    }
}

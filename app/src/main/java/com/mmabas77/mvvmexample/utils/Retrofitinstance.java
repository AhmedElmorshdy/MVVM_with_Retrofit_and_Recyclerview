package com.mmabas77.mvvmexample.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitinstance {
   public static final String baseUrl = "https://jsonplaceholder.typicode.com/";
   private  static Retrofit retrofit;
    RetrofitInterface retrofitInterface;

    public static Retrofit getData(){

        if (retrofit==null){

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }

}

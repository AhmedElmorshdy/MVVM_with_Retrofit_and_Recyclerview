package com.mmabas77.mvvmexample.utils;

import com.mmabas77.mvvmexample.pojo.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("posts")
    Call<List<Model>>getPosts();
}

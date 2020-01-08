package com.example.gatewayimpl;


import com.example.entity.TrendingRespositry;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("repositories?since=daily/")
    Call<ArrayList<TrendingRespositry>> getResult();
}
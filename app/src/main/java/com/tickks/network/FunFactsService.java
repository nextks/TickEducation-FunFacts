package com.tickks.network;

import com.tickks.data.Fact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FunFactsService {


  @GET("v2/5da882131200005400edaf86")
  Call<List<Fact>> getAllFacts();


  @POST("v2/5da882131200005400edaf86")
  Call<Void> addNewFact(@Body Fact fact);


}

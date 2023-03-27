package com.metropolitan.it355.dz14.client;

import com.metropolitan.it355.dz14.model.Member;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "http://10.0.2.2:8080/Lekcija5Primer1_war_exploded/";

    @Headers("Content-Type: application/json")
    @GET("members/{id}")
    Call<Member> getMember(@Path("id") Integer userId);


}

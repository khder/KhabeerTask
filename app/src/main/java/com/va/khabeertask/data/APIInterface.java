package com.va.khabeertask.data;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInterface {
    @POST("LogIn")
    Call<ResponseBody> login(@Body RequestBody loginData);
    @GET("GetPayroll")
    Call<ResponseBody> getPayRoll(@Header("Authorization") String authHeader);

}

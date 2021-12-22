package com.va.khabeertask.data;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class APIClient {
    public static String BASE_URL ="http://40.127.194.127:5656/Salamtak/";
    private static Retrofit retrofit;
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }
}

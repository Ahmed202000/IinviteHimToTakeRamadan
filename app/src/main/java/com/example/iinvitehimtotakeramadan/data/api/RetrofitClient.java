package com.example.iinvitehimtotakeramadan.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit=null;
    private static String BASE_URL="https://api.aladhan.com/";

    public static ApiServic getClient(){

        if (retrofit==null){

            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ApiServic.class);
    }
}

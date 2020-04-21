package com.example.iinvitehimtotakeramadan.data.api;

import com.example.iinvitehimtotakeramadan.data.modale.prayer.Prayer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServic {

    @GET("timingsByAddress")
    Call<Prayer> getPrayer(@Query("date")String date,
                           @Query("address")String address,
                           @Query("method")int method);


}

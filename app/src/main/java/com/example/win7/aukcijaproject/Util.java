package com.example.win7.aukcijaproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by win7 on 24.5.2017.
 */

public class Util {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://178.222.214.110/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static RestService restService = retrofit.create(RestService.class);

}

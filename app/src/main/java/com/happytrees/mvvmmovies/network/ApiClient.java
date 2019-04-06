package com.happytrees.mvvmmovies.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String URL = "https://api.themoviedb.org/3/";

    //SINGLETON retrofit
    private static Retrofit retrofit;

    //private constructor
    private ApiClient() {
    }

    public static Retrofit getClient() {
        if (retrofit == null) {//create singleton instance of retrofit
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

package com.happytrees.mvvmmovies.network;


import com.happytrees.mvvmmovies.model.ResponseMovies;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("movie/top_rated?api_key=281181dbefe0c9f3d4af2d13adc51454")
    Call<ResponseMovies> getMovieResponse();

}

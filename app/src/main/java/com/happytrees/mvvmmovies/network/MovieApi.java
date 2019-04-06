package com.happytrees.mvvmmovies.network;

import android.util.Log;

import com.happytrees.mvvmmovies.model.ResponseMovies;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieApi {
    private ApiInterface mApiInterface;
    private OnServerResponseListener mOnServerResponseListener;

    //SINGLETON MovieApi instance
    private static MovieApi mMovieApi;

    private MovieApi() {
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public static MovieApi getMovieApi() {
        if (mMovieApi == null) {
            mMovieApi = new MovieApi();
        }
        return mMovieApi;
    }


    public void loadMovies(final OnServerResponseListener listener) { //OnServerResponseListener listener
        Call<ResponseMovies> call = mApiInterface.getMovieResponse();
        call.enqueue(new Callback<ResponseMovies>() {
            @Override
            public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
                   ResponseMovies responseMovies = response.body();
                   listener.OnServerResponse(true, responseMovies);
            }

            @Override
            public void onFailure(Call<ResponseMovies> call, Throwable t) {
                   listener.OnServerResponse(false, null);
            }
        });
    }

    public interface OnServerResponseListener{
        void OnServerResponse(boolean isSuccess, ResponseMovies responseMovies);
    }

}


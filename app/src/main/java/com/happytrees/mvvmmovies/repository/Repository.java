package com.happytrees.mvvmmovies.repository;

import android.arch.lifecycle.MutableLiveData;

import com.happytrees.mvvmmovies.model.Movie;
import com.happytrees.mvvmmovies.model.ResponseMovies;
import com.happytrees.mvvmmovies.network.MovieApi;

import java.util.List;

public class Repository {

    private MovieApi mMovieApi;
    private MutableLiveData<List<Movie>>mListMovieMLD;

    //SINGLETON repository
    private static Repository mRepository;

    //private constructor
    private Repository() {
        mMovieApi = MovieApi.getMovieApi();
        mListMovieMLD = new MutableLiveData<>();
    }

    public static Repository getRepository() {

        if (mRepository == null) {
            mRepository = new Repository();
        }

        return mRepository;
    }

    public void loadMovies() {
        mMovieApi.loadMovies(new MovieApi.OnServerResponseListener() {
            @Override
            public void OnServerResponse(boolean isSuccess, ResponseMovies responseMovies) {
                if (isSuccess) {
                    mListMovieMLD.setValue(responseMovies.getMovieList());
                }
            }
        });
    }

    public MutableLiveData<List<Movie>> getMovies() {
        return mListMovieMLD;
    }
}


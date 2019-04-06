package com.happytrees.mvvmmovies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMovies {

    @SerializedName("results")
    private List<Movie>mMovieList;

    public List<Movie> getMovieList() {
        return mMovieList;
    }
}

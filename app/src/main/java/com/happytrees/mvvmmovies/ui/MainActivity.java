package com.happytrees.mvvmmovies.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.happytrees.mvvmmovies.R;
import com.happytrees.mvvmmovies.model.Movie;
import com.happytrees.mvvmmovies.viewmodel.MovieViewModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MovieViewModel mMovieViewModel;
    private boolean mIsLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mIsLoaded = savedInstanceState.getBoolean("isLoaded", false);
        }

        mMovieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);

        if (!mIsLoaded) {
            mMovieViewModel.loadMovies();
        }

        mMovieViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                if (movies.size() > 0) {
                    mIsLoaded = true;
                }

                Collections.sort(movies, new Comparator<Movie>() {
                    public int compare(Movie m1, Movie m2) {
                        return m2.getReleaseDate().compareTo(m1.getReleaseDate());
                    }
                });

                for (Movie movie : movies) {
                    Log.e("m " + movie.getTitle(), movie.getReleaseDate() + "\n ");
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isLoaded", mIsLoaded);
    }
}

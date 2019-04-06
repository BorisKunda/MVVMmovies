package com.happytrees.mvvmmovies.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.happytrees.mvvmmovies.model.Movie;
import com.happytrees.mvvmmovies.repository.Repository;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private Repository mRepository;

    public MovieViewModel() {
        mRepository = Repository.getRepository();
    }

    public void loadMovies() {
        mRepository.loadMovies();
    }

    public MutableLiveData<List<Movie>> getMovies() {
        return mRepository.getMovies();
    }

}

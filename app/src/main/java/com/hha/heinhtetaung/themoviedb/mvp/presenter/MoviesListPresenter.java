package com.hha.heinhtetaung.themoviedb.mvp.presenter;

import android.content.Context;

import com.hha.heinhtetaung.themoviedb.data.Model.MovieModel;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.mvp.view.MoviesListView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class MoviesListPresenter extends BasePresenter {
    private MoviesListView moviesListView;
    private Context context;

    public MoviesListPresenter(Context context, MoviesListView moviesListView) {
        this.moviesListView = moviesListView;
        this.context = context;

    }

    public void onDisplayMovieList(List<MovieDetailVo> movieList) {
        moviesListView.onPouplarDisplay(movieList);
    }

    public void loadPopularMovies() {
        MovieModel.getsObjInstance().loadMovie();
    }
}

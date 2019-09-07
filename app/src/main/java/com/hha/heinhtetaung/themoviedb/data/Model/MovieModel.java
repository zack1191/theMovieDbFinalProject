package com.hha.heinhtetaung.themoviedb.data.Model;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.data.VO.ReviewsVo;
import com.hha.heinhtetaung.themoviedb.data.VO.TrailerVo;
import com.hha.heinhtetaung.themoviedb.events.LoadMovieDbEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadNowShowingEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadReviewEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadSearchMovieEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadTrailerEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadUpcomingEvent;
import com.hha.heinhtetaung.themoviedb.network.MovieDataAgent;
import com.hha.heinhtetaung.themoviedb.network.RetrofitDataAgent;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieModel {
    private static MovieModel sObjInstance;
    private MovieDataAgent mMovieDataAgent;


    private Map<String, MovieDetailVo> movieDB;
    private Map<String, List<TrailerVo>> trailer;

    public MovieModel() {

        movieDB = new HashMap<>();
        mMovieDataAgent = RetrofitDataAgent.getsObjInstance();
//        mUpcomingDataAgent = RetrofitDataAgent.getsObjInstance();
        EventBus.getDefault().register(this);
    }

    public static MovieModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new MovieModel();
        }
        return sObjInstance;
    }

    public void loadMovie() {
        mMovieDataAgent.loadMovie();
    }

    public void loadTrailer(Context context, String movieId) {
        mMovieDataAgent.loadMovieTrailers(context, movieId);
    }

    public void loadUpcoming() {
        mMovieDataAgent.loadUpcoming();
    }

    public void loadNowshowing() {
        mMovieDataAgent.loadNowshowing();
    }

    public void loadSearchMovies(String query) {
        mMovieDataAgent.loadSearchMovie(query);
    }


    public MovieDetailVo getMovieDbById(String movieDbId) {
        return movieDB.get(movieDbId);
    }

    public void loadReview(String movieId) {
        mMovieDataAgent.loadMovieReview(movieId);
    }


//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    public void onMoveLoaded(LoadMovieEvent event) {
//        Log.d("a", "onNewsLoaded : " + event.getMovieList().size());
//        for (MovieVo movie : event.getMovieList()) {
//
//            mMovie.put(movie.getId(), movie);
//        }
//    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMovieDbLoaded(LoadMovieDbEvent event) {
        Log.d("a", "onMovieLoaded : " + event.getMovieDbList().size());
        for (MovieDetailVo movieDBVo : event.getMovieDbList()) {
            movieDB.put(movieDBVo.getmId(), movieDBVo);
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onUpcomingLoaded(LoadUpcomingEvent event) {
        Log.d("a", "onUpcomeLoaded : " + event.getMovieDbList().size());
        for (MovieDetailVo movieDBVo : event.getMovieDbList()) {
            movieDB.put(movieDBVo.getmId(), movieDBVo);
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNowshowingLoaded(LoadNowShowingEvent event) {
        Log.d("a", "onNowshowingLoaded : " + event.getMovieDbList().size());
        for (MovieDetailVo movieDBVo : event.getMovieDbList()) {
            movieDB.put(movieDBVo.getmId(), movieDBVo);
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoadedEvent(LoadTrailerEvent event) {
        Log.d("a", "onTrailerLoaded : " + event.getMovieDbList().size());
        List<TrailerVo> trailerVoList = event.getMovieDbList();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSearchLoadedEvent(LoadSearchMovieEvent event) {
        for (MovieDetailVo movieDBVo : event.getMovieDbList()) {
            movieDB.put(movieDBVo.getmId(), movieDBVo);
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onReviewLoadedEvent(LoadReviewEvent event) {
        List<ReviewsVo> reviewsVos = event.getMovieDbList();
    }

}

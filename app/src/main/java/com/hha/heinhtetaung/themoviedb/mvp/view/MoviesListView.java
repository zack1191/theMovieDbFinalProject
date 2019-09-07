package com.hha.heinhtetaung.themoviedb.mvp.view;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

import java.util.List;

public interface MoviesListView {
    void onPouplarDisplay(List<MovieDetailVo> mPopularList);

    void onUpcomeDisplay(List<MovieDetailVo> mUpcomeList);

    void onMovieLoadFailed(String message);

}

package com.hha.heinhtetaung.themoviedb.events;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

import java.util.List;

public class LoadNowShowingEvent {
    private List<MovieDetailVo> movieDBVos;

    public LoadNowShowingEvent(List<MovieDetailVo> movieDBVos) {
        this.movieDBVos = movieDBVos;
    }

    public List<MovieDetailVo> getMovieDbList() {
        return movieDBVos;
    }
}

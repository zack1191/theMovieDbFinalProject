package com.hha.heinhtetaung.themoviedb.events;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

import java.util.List;

public class LoadSearchMovieEvent {
    private List<MovieDetailVo> movieDBVos;

    public LoadSearchMovieEvent(List<MovieDetailVo> movieDBVos) {
        this.movieDBVos = movieDBVos;
    }

    public List<MovieDetailVo> getMovieDbList() {
        return movieDBVos;
    }
}

package com.hha.heinhtetaung.themoviedb.events;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

import java.util.List;

public class LoadUpcomingEvent {
    private List<MovieDetailVo> movieDBVos;

    public LoadUpcomingEvent(List<MovieDetailVo> movieDBVos) {
        this.movieDBVos = movieDBVos;
    }

    public List<MovieDetailVo> getMovieDbList() {
        return movieDBVos;
    }
}

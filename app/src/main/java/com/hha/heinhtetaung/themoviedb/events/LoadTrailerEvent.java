package com.hha.heinhtetaung.themoviedb.events;

import android.content.Context;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.data.VO.TrailerVo;
import com.hha.heinhtetaung.themoviedb.network.responses.GetTrailerResponse;

import java.util.List;

public class LoadTrailerEvent {
    private List<TrailerVo> movieDBVos;

    public LoadTrailerEvent(List<TrailerVo> movieDBVos) {
        this.movieDBVos = movieDBVos;
    }

    public List<TrailerVo> getMovieDbList() {
        return movieDBVos;
    }
}

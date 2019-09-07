package com.hha.heinhtetaung.themoviedb.events;

import com.hha.heinhtetaung.themoviedb.data.VO.ReviewsVo;
import com.hha.heinhtetaung.themoviedb.data.VO.TrailerVo;

import java.util.List;

public class LoadReviewEvent {
    private List<ReviewsVo> movieDBVos;

    public LoadReviewEvent(List<ReviewsVo> movieDBVos) {
        this.movieDBVos = movieDBVos;
    }

    public List<ReviewsVo> getMovieDbList() {
        return movieDBVos;
    }
}

package com.hha.heinhtetaung.themoviedb.contorller;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

public interface UpComingDelegate {
    void onTapUpcomingItems(MovieDetailVo movieDBVo);
}

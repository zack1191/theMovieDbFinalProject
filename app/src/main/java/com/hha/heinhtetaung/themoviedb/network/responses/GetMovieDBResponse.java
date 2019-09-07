package com.hha.heinhtetaung.themoviedb.network.responses;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

import java.util.List;

public class GetMovieDBResponse {

    private int page;
    private int total_results;
    private int total_pages;
    private List<MovieDetailVo> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<MovieDetailVo> getResults() {
        return results;
    }

    public void setResults(List<MovieDetailVo> results) {
        this.results = results;
    }
}

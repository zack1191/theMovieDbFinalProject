package com.hha.heinhtetaung.themoviedb.network.responses;

import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

import java.util.List;

public class GetSearchResponse {
    @SerializedName("page")
    private Long page;
    @SerializedName("results")
    private List<MovieDetailVo> results;
    @SerializedName("total_pages")
    private Long totalPages;
    @SerializedName("total_results")
    private Long totalResults;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<MovieDetailVo> getResults() {
        return results;
    }

    public void setResults(List<MovieDetailVo> results) {
        this.results = results;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }
}

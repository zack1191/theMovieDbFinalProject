package com.hha.heinhtetaung.themoviedb.network.responses;

import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.themoviedb.data.VO.ReviewsVo;

import java.util.ArrayList;
import java.util.List;

public class GetMovieReviewResponse {

    @SerializedName("id")
    private String movieId;

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<ReviewsVo> reviewList;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("total_results")
    private int totalResults;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<ReviewsVo> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<ReviewsVo> reviewList) {
        this.reviewList = reviewList;
    }

    public void setReviewList(ArrayList<ReviewsVo> reviewList) {
        this.reviewList = reviewList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}

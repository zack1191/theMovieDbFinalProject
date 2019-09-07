package com.hha.heinhtetaung.themoviedb.data.VO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDBVo {
    private String overview;

    private String original_language;

    private String original_title;

    private String video;

    private String title;

    @SerializedName("runtime")
    private Long mRuntime;
    @SerializedName("genres")
    private List<GenreVo> mGenres;

    private String[] genre_ids;

    private String poster_path;

    private String backdrop_path;

    private String release_date;

    private String vote_average;

    private String popularity;

    private String id;

    private String adult;

    private String vote_count;

    private List<TrailerVo> trailerList;


    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(String[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public Long getmRuntime() {
        return mRuntime;
    }

    public void setmRuntime(Long mRuntime) {
        this.mRuntime = mRuntime;
    }

    public List<GenreVo> getmGenres() {
        return mGenres;
    }

    public void setmGenres(List<GenreVo> mGenres) {
        this.mGenres = mGenres;
    }

    public List<TrailerVo> getTrailerList() {
        return trailerList;
    }

    public void setTrailerList(List<TrailerVo> trailerList) {
        this.trailerList = trailerList;
    }
}

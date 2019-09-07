package com.hha.heinhtetaung.themoviedb.data.VO;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailVo implements ShareParentVo {
    // new
    @SerializedName("belongs_to_collection")
    private Object mBelongsToCollection;

    @SerializedName("budget")
    private Long mBudget;

    @SerializedName("genres")
    private List<GenreVo> mGenres;

    @SerializedName("homepage")
    private String mHomepage;

    @SerializedName("imdb_id")
    private String mImdbId;

    @SerializedName("revenue")
    private Long mRevenue;

    @SerializedName("runtime")
    private Long mRuntime;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("tagline")
    private String mTagline;
    //>
    @SerializedName("adult")
    private Boolean mAdult;

    @SerializedName("backdrop_path")
    private String mBackdropPath;

    @SerializedName("genre_ids")
    private List<Long> mGenreIds;

    @SerializedName("id")
    private Long mId;

    @SerializedName("original_language")
    private String mOriginalLanguage;

    @SerializedName("original_title")
    private String mOriginalTitle;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("popularity")
    private Double mPopularity;

    @SerializedName("poster_path")
    private String mPosterPath;

    @SerializedName("release_date")
    private String mReleaseDate;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("video")
    private Boolean mVideo;

    @SerializedName("vote_average")
    private Double mVoteAverage;

    @SerializedName("vote_count")
    private Long mVoteCount;

    private boolean isFavorite;

    private int movieType;


    private List<TrailerVo> trailerList;
    private List<ReviewsVo> reviewsList;

    public List<ReviewsVo> getReviewsList() {
        return reviewsList;
    }

    public void setReviewsList(List<ReviewsVo> reviewsList) {
        this.reviewsList = reviewsList;
    }

    public Object getmBelongsToCollection() {
        return mBelongsToCollection;
    }

    public void setmBelongsToCollection(Object mBelongsToCollection) {
        this.mBelongsToCollection = mBelongsToCollection;
    }

    public Long getmBudget() {
        return mBudget;
    }

    public void setmBudget(Long mBudget) {
        this.mBudget = mBudget;
    }

    public List<GenreVo> getmGenres() {
        return mGenres;
    }

    public void setmGenres(List<GenreVo> mGenres) {
        this.mGenres = mGenres;
    }

    public String getmHomepage() {
        return mHomepage;
    }

    public void setmHomepage(String mHomepage) {
        this.mHomepage = mHomepage;
    }

    public String getmImdbId() {
        return mImdbId;
    }

    public void setmImdbId(String mImdbId) {
        this.mImdbId = mImdbId;
    }

    public Long getmRevenue() {
        return mRevenue;
    }

    public void setmRevenue(Long mRevenue) {
        this.mRevenue = mRevenue;
    }

    public Long getmRuntime() {
        return mRuntime;
    }

    public void setmRuntime(Long mRuntime) {
        this.mRuntime = mRuntime;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getmTagline() {
        return mTagline;
    }

    public void setmTagline(String mTagline) {
        this.mTagline = mTagline;
    }

    public Boolean getmAdult() {
        return mAdult;
    }

    public void setmAdult(Boolean mAdult) {
        this.mAdult = mAdult;
    }

    public String getmBackdropPath() {
        return mBackdropPath;
    }

    public void setmBackdropPath(String mBackdropPath) {
        this.mBackdropPath = mBackdropPath;
    }

    public List<Long> getmGenreIds() {
        return mGenreIds;
    }

    public void setmGenreIds(List<Long> mGenreIds) {
        this.mGenreIds = mGenreIds;
    }

    public String getmId() {
        return String.valueOf(mId);
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmOriginalLanguage() {
        return mOriginalLanguage;
    }

    public void setmOriginalLanguage(String mOriginalLanguage) {
        this.mOriginalLanguage = mOriginalLanguage;
    }

    public String getmOriginalTitle() {
        return mOriginalTitle;
    }

    public void setmOriginalTitle(String mOriginalTitle) {
        this.mOriginalTitle = mOriginalTitle;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public Double getmPopularity() {
        return mPopularity;
    }

    public void setmPopularity(Double mPopularity) {
        this.mPopularity = mPopularity;
    }

    public String getmPosterPath() {
        return mPosterPath;
    }

    public void setmPosterPath(String mPosterPath) {
        this.mPosterPath = mPosterPath;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public void setmReleaseDate(String mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Boolean getmVideo() {
        return mVideo;
    }

    public void setmVideo(Boolean mVideo) {
        this.mVideo = mVideo;
    }

    public Double getmVoteAverage() {
        return mVoteAverage;
    }

    public void setmVoteAverage(Double mVoteAverage) {
        this.mVoteAverage = mVoteAverage;
    }

    public Long getmVoteCount() {
        return mVoteCount;
    }

    public void setmVoteCount(Long mVoteCount) {
        this.mVoteCount = mVoteCount;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getMovieType() {
        return movieType;
    }

    public void setMovieType(int movieType) {
        this.movieType = movieType;
    }

    public List<TrailerVo> getTrailerList() {
        return trailerList;
    }

    public void setTrailerList(List<TrailerVo> trailerList) {
        this.trailerList = trailerList;
    }
}

package com.hha.heinhtetaung.themoviedb.network.responses;

import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.themoviedb.data.VO.TrailerVo;

import java.util.List;

public class GetTrailerResponse {
    @SerializedName("id")
    private Long mId;
    @SerializedName("results")
    private List<TrailerVo> mTrailers;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<TrailerVo> getTrailers() {
        return mTrailers;
    }

    public void setTrailer(List<TrailerVo> trailerVOs) {
        mTrailers = trailerVOs;
    }
}

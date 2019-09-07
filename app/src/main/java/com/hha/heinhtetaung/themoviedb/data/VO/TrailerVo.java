package com.hha.heinhtetaung.themoviedb.data.VO;

import android.content.ContentValues;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrailerVo {
    public static final String YOUTUBE_TRAILER_PREVIEW_PATH = "http://img.youtube.com/vi/%s/0.jpg";
    public static final String COLUMN_TRAILER_ID = "trailer_id";
    public static final String COLUMN_TRAILER_KEY = "key";
    public static final String COLUMN_TRAILER_NAME = "name";
    public static final String COLUMN_MOVIE_ID = "movie_id";
    @SerializedName("id")
    private String mId;
    @SerializedName("iso_3166_1")
    private String mIso31661;
    @SerializedName("iso_639_1")
    private String mIso6391;
    @SerializedName("key")
    private String mKey;
    @SerializedName("name")
    private String mName;
    @SerializedName("site")
    private String mSite;
    @SerializedName("size")
    private Long mSize;
    @SerializedName("type")
    private String mType;

    public String getTrailerPath() {
        return String.format(YOUTUBE_TRAILER_PREVIEW_PATH, mKey);
    }

    public static String getYoutubeTrailerPreviewPath() {
        return YOUTUBE_TRAILER_PREVIEW_PATH;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmIso31661() {
        return mIso31661;
    }

    public void setmIso31661(String mIso31661) {
        this.mIso31661 = mIso31661;
    }

    public String getmIso6391() {
        return mIso6391;
    }

    public void setmIso6391(String mIso6391) {
        this.mIso6391 = mIso6391;
    }

    public String getmKey() {
        return mKey;
    }

    public void setmKey(String mKey) {
        this.mKey = mKey;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSite() {
        return mSite;
    }

    public void setmSite(String mSite) {
        this.mSite = mSite;
    }

    public Long getmSize() {
        return mSize;
    }

    public void setmSize(Long mSize) {
        this.mSize = mSize;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }


}

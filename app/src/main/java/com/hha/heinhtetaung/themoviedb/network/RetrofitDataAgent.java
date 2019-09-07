package com.hha.heinhtetaung.themoviedb.network;

import android.content.Context;

import com.google.gson.Gson;
import com.hha.heinhtetaung.themoviedb.events.LoadMovieDbEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadNowShowingEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadReviewEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadSearchMovieEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadTrailerEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadUpcomingEvent;
import com.hha.heinhtetaung.themoviedb.network.responses.GetMovieDBResponse;
import com.hha.heinhtetaung.themoviedb.network.responses.GetMovieReviewResponse;
import com.hha.heinhtetaung.themoviedb.network.responses.GetSearchResponse;
import com.hha.heinhtetaung.themoviedb.network.responses.GetTrailerResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgent implements MovieDataAgent {
    private static RetrofitDataAgent sObjInstance;
    private MovieApi movieApi;
    private static String BASE_URL = "https://api.themoviedb.org";
    private static int PAGE = 1;
    private static String API_KEY = "cd352cb0a2b917df47bf44c3956bfa1a";
    private static String LANGUAGE = "en-US";
    private static String CATEGORY = "popular";
    private static String CATEGORY_UPCOME = "upcoming";
    private static String NOWSHOWING = "now_playing";
    private static String SERIES = "now_playing";
    private static String LATEST = "top_rated";
    private static String MOVIE_ID = "movieId";


    public RetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder()//creat okhttpclient
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()//creat retrofit object
//                .baseUrl("http://padcmyanmar.com/padc-3/popular-movies/apis/v1/")
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();
        movieApi = retrofit.create(MovieApi.class);
    }

//    @Override
//    public void loadMovie() {
//        Call<GetMovieResponse> getMovieResponseCall = movieApi.getMovies(1, "b002c7e1a528b7cb460933fc2875e916");
//        getMovieResponseCall.enqueue(new Callback<GetMovieResponse>() {
//            @Override
//            public void onResponse(Call<GetMovieResponse> call, Response<GetMovieResponse> response) {
//                GetMovieResponse getMovieResponse = response.body();
//                if (getMovieResponse != null) {
//                    LoadMovieEvent event = new LoadMovieEvent(getMovieResponse.getMovie());
//                    EventBus.getDefault().post(event);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<GetMovieResponse> call, Throwable t) {
//
//            }
//        });
//
//    }

    public static RetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new RetrofitDataAgent();
        }
        return sObjInstance;
    }

    @Override
    public void loadMovie() {
        Call<GetMovieDBResponse> call = movieApi.getMoviesdb(CATEGORY, API_KEY, LANGUAGE, PAGE);

        call.enqueue(new Callback<GetMovieDBResponse>() {
            @Override
            public void onResponse(Call<GetMovieDBResponse> call, Response<GetMovieDBResponse> response) {
                GetMovieDBResponse getdbResponse = response.body();
                if (getdbResponse != null) {
                    LoadMovieDbEvent event = new LoadMovieDbEvent(getdbResponse.getResults());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetMovieDBResponse> call, Throwable t) {

            }
        });


    }

    @Override
    public void loadUpcoming() {
        Call<GetMovieDBResponse> call = movieApi.getMoviesdb(CATEGORY_UPCOME, API_KEY, LANGUAGE, PAGE);
        call.enqueue(new Callback<GetMovieDBResponse>() {
            @Override
            public void onResponse(Call<GetMovieDBResponse> call, Response<GetMovieDBResponse> response) {
                GetMovieDBResponse getdbResponse = response.body();
                if (getdbResponse != null) {
                    LoadUpcomingEvent event = new LoadUpcomingEvent(getdbResponse.getResults());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetMovieDBResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadNowshowing() {
        Call<GetMovieDBResponse> call = movieApi.getMoviesdb(NOWSHOWING, API_KEY, LANGUAGE, PAGE);
        call.enqueue(new Callback<GetMovieDBResponse>() {
            @Override
            public void onResponse(Call<GetMovieDBResponse> call, Response<GetMovieDBResponse> response) {
                GetMovieDBResponse getdbResponse = response.body();
                if (getdbResponse != null) {
                    LoadNowShowingEvent event = new LoadNowShowingEvent(getdbResponse.getResults());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetMovieDBResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadMovieTrailers(Context context, String movieId) {
        Call<GetTrailerResponse> call = movieApi.getMovieTrailer(movieId, API_KEY);
        call.enqueue(new Callback<GetTrailerResponse>() {
            @Override
            public void onResponse(Call<GetTrailerResponse> call, Response<GetTrailerResponse> response) {
                GetTrailerResponse getTrailerResponse = response.body();
                if (getTrailerResponse != null) {
                    LoadTrailerEvent event = new LoadTrailerEvent(getTrailerResponse.getTrailers());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetTrailerResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadSearchMovie(String query) {
        Call<GetSearchResponse> call = movieApi.getSearchMovies(query, API_KEY);
        call.enqueue(new Callback<GetSearchResponse>() {
            @Override
            public void onResponse(Call<GetSearchResponse> call, Response<GetSearchResponse> response) {
                GetSearchResponse getdbResponse = response.body();
                if (getdbResponse != null) {
                    LoadSearchMovieEvent event = new LoadSearchMovieEvent(getdbResponse.getResults());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetSearchResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadMovieReview(String movieId) {
        Call<GetMovieReviewResponse> call = movieApi.getReviewMovies(movieId, API_KEY);
        call.enqueue(new Callback<GetMovieReviewResponse>() {
            @Override
            public void onResponse(Call<GetMovieReviewResponse> call, Response<GetMovieReviewResponse> response) {
                GetMovieReviewResponse getMovieReviewResponse = response.body();
                if (getMovieReviewResponse != null) {
                    LoadReviewEvent event = new LoadReviewEvent(getMovieReviewResponse.getReviewList());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetMovieReviewResponse> call, Throwable t) {

            }
        });


    }


}

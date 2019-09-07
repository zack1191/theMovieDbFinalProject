package com.hha.heinhtetaung.themoviedb.network;

import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.network.responses.GetMovieDBResponse;
import com.hha.heinhtetaung.themoviedb.network.responses.GetMovieReviewResponse;
import com.hha.heinhtetaung.themoviedb.network.responses.GetSearchResponse;
import com.hha.heinhtetaung.themoviedb.network.responses.GetTrailerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
//    @FormUrlEncoded
//    @POST("getPopularMovies.php")
//    Call<GetMovieResponse> getMovies(@Field("page") int page,
//                                     @Field("access_token") String accessToken);

    @GET("/3/movie/{category}")
    Call<GetMovieDBResponse> getMoviesdb(
            @Path("category") String category,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("/3/movie/{movie_id}")
    Call<MovieDetailVo> getMovieDetail(
            @Path("movieId") long movieId,
            @Query("api_key") String apiKey
    );

    @GET("/3/movie/{movieId}/videos")
    Call<GetTrailerResponse> getMovieTrailer(
            @Path("movieId") String movieId,
            @Query("api_key") String apiKey
    );

    @GET("/3/search/movie")
    Call<GetSearchResponse> getSearchMovies(
            @Query("query") String query,
            @Query("api_key") String apiKey
    );

    @GET("/3/movie/{movieId}/reviews")
    Call<GetMovieReviewResponse> getReviewMovies(
            @Path("movieId") String movieId,
            @Query("api_key") String apiKey
    );
}

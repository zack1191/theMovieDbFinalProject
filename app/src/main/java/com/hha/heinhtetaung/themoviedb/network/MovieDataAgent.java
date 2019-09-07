package com.hha.heinhtetaung.themoviedb.network;

import android.content.Context;

public interface MovieDataAgent {
    void loadMovie();

    void loadUpcoming();

    void loadNowshowing();

    void loadMovieTrailers(Context context, String movieId);

    void loadSearchMovie(String query);

    void loadMovieReview(String movieId);


}

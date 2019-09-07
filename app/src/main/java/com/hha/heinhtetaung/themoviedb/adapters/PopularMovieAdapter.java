package com.hha.heinhtetaung.themoviedb.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.contorller.MovieDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.viewholders.PopularViewHolder;

public class PopularMovieAdapter extends BaseRecyclerAdapter<PopularViewHolder, MovieDetailVo> {
    private MovieDelegate mMovieDelegate;
    private MovieDetailVo movieDetailVo;


    public PopularMovieAdapter(Context context, MovieDelegate movieDelegate) {
        super(context);
        this.mMovieDelegate = movieDelegate;
    }


    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_popular, parent, false);
        return new PopularViewHolder(view, mMovieDelegate);
    }

}

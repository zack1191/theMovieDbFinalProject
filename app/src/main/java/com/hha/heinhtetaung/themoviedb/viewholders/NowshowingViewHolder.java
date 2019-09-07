package com.hha.heinhtetaung.themoviedb.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.contorller.MovieDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

import butterknife.BindView;

public class NowshowingViewHolder extends BaseViewHolder<MovieDetailVo> {

    @BindView(R.id.iv_background_nowshowing)
    ImageView ivNowshowing;

//    @BindView(R.id.tv_name_nowshowing)
//    TextView tvNowShowing;

    private MovieDelegate mMovieDelegate;

    private MovieDetailVo mMovieDb;

    public NowshowingViewHolder(View itemView, MovieDelegate movieDelegate) {
        super(itemView);
        mMovieDelegate = movieDelegate;
    }

    @Override
    public void setData(MovieDetailVo data) {
        mMovieDb = data;
//        tvNowShowing.setText(data.getmTitle());
        if (data.getmPosterPath() != null) {
            ivNowshowing.setVisibility(View.VISIBLE);
            Glide.with(ivNowshowing.getContext())
                    .load("http://image.tmdb.org/t/p/original" + data.getmPosterPath())
                    .into(ivNowshowing);
        } else {
            ivNowshowing.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        mMovieDelegate.onTapNowShowing(mMovieDb);
    }
}

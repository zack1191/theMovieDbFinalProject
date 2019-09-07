package com.hha.heinhtetaung.themoviedb.viewholders;

import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.contorller.MovieDelegate;
import com.hha.heinhtetaung.themoviedb.contorller.UpComingDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

import butterknife.BindView;

public class UpComingMovieViewHolder extends BaseViewHolder<MovieDetailVo> {

    @BindView(R.id.iv_background_upc)
    ImageView ivBackground;

    @BindView(R.id.tv_name_upc)
    TextView tvTitle;

    private UpComingDelegate mMovieDelegate;
    private MovieDetailVo mMovieDb;

    public UpComingMovieViewHolder(View itemView, UpComingDelegate upComingDelegate) {
        super(itemView);
        mMovieDelegate = upComingDelegate;
    }

    @Override
    public void setData(MovieDetailVo data) {
        mMovieDb = data;

        tvTitle.setText(data.getmTitle());
        if (data.getmPosterPath() != null) {
            ivBackground.setVisibility(View.VISIBLE);
            Glide.with(ivBackground.getContext())
                    .load("http://image.tmdb.org/t/p/original" + data.getmPosterPath())
                    .into(ivBackground);
        } else {
            ivBackground.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        mMovieDelegate.onTapUpcomingItems(mMovieDb);
    }
}

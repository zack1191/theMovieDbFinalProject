package com.hha.heinhtetaung.themoviedb.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.contorller.MovieDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopularViewHolder extends BaseViewHolder<MovieDetailVo> {

    @BindView(R.id.iv_background)
    ImageView ivBackground;

    @BindView(R.id.tv_name)
    TextView tvMovieName;


    private MovieDelegate mMovieDelegate;


    private MovieDetailVo mMovieDb;


    public PopularViewHolder(View itemView, MovieDelegate movieDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mMovieDelegate = movieDelegate;

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        mMovieDelegate.onTapMovieItems(mMovieDb);

    }

    @Override
    public void setData(MovieDetailVo data) {
        mMovieDb = data;
        tvMovieName.setText(data.getmTitle());
        if (data.getmPosterPath() != null) {
            ivBackground.setVisibility(View.VISIBLE);
            Glide.with(ivBackground.getContext())
                    .load("http://image.tmdb.org/t/p/original" + data.getmPosterPath())
                    .into(ivBackground);
        } else {
            ivBackground.setVisibility(View.GONE);
        }


    }
}

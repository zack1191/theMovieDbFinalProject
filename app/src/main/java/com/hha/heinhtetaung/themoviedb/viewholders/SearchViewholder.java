package com.hha.heinhtetaung.themoviedb.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.contorller.SearchMovieDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchViewholder extends BaseViewHolder<MovieDetailVo> {

    @BindView(R.id.iv_background_search)
    ImageView ivSearch;

//    @BindView(R.id.tv_name_search)
//    TextView tvNameSearch;

    public MovieDetailVo movieDetailVo;
    private SearchMovieDelegate movieDelegate;

    public SearchViewholder(View itemView, SearchMovieDelegate mSearchMovieDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        movieDelegate = mSearchMovieDelegate;

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        movieDelegate.onTapSearchMovie(movieDetailVo);
    }

    @Override
    public void setData(MovieDetailVo data) {
        movieDetailVo = data;
//        tvNameSearch.setText(data.getmTitle());
        if (data.getmPosterPath() != null) {
            ivSearch.setVisibility(View.VISIBLE);
            Glide.with(ivSearch.getContext())
                    .load("http://image.tmdb.org/t/p/original" + data.getmPosterPath())
                    .into(ivSearch);
        } else {
            ivSearch.setVisibility(View.GONE);
        }
    }
}

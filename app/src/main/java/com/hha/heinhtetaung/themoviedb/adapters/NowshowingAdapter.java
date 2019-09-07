package com.hha.heinhtetaung.themoviedb.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.contorller.MovieDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.viewholders.NowshowingViewHolder;
import com.hha.heinhtetaung.themoviedb.viewholders.PopularViewHolder;

public class NowshowingAdapter extends BaseRecyclerAdapter<NowshowingViewHolder, MovieDetailVo> {
    private MovieDelegate mMovieDelegate;

    public NowshowingAdapter(Context context, MovieDelegate movieDelegate) {
        super(context);
        mMovieDelegate = movieDelegate;
    }

    @NonNull
    @Override
    public NowshowingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_nowshowing, parent, false);
        return new NowshowingViewHolder(view, mMovieDelegate);
    }
}

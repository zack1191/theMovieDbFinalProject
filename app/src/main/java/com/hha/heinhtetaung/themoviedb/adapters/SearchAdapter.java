package com.hha.heinhtetaung.themoviedb.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.contorller.SearchMovieDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.viewholders.PopularViewHolder;
import com.hha.heinhtetaung.themoviedb.viewholders.SearchViewholder;

public class SearchAdapter extends BaseRecyclerAdapter<SearchViewholder, MovieDetailVo> {
    private SearchMovieDelegate movieDelegate;

    public SearchAdapter(Context context, SearchMovieDelegate mSearchMovieDelegate) {
        super(context);
        movieDelegate = mSearchMovieDelegate;
    }

    @NonNull
    @Override
    public SearchViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_search, parent, false);
        return new SearchViewholder(view, movieDelegate);
    }
}

package com.hha.heinhtetaung.themoviedb.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.adapters.PopularMovieAdapter;
import com.hha.heinhtetaung.themoviedb.contorller.MovieDelegate;
import com.hha.heinhtetaung.themoviedb.data.Model.MovieModel;
import com.hha.heinhtetaung.themoviedb.events.LoadMovieDbEvent;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopularMovieFragment extends Fragment {
    private PopularMovieAdapter mPopularMovieAdapter;
    private MovieDelegate movieDelegate;


    @BindView(R.id.rv_cinema)
    RecyclerView rvCinema;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_popular_movie, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();

        MovieModel.getsObjInstance().loadMovie();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        movieDelegate = (MovieDelegate) context;
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);

    }

    private void setupRecyclerView() {
        mPopularMovieAdapter = new PopularMovieAdapter(this.getContext(), movieDelegate);
        rvCinema.setLayoutManager(new GridLayoutManager(this.getContext(), 3, GridLayoutManager.VERTICAL, false));
        rvCinema.setAdapter(mPopularMovieAdapter);
    }

    public static PopularMovieFragment newInstance() {
        PopularMovieFragment fragment = new PopularMovieFragment();
        return fragment;
    }

    //    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMoveLoaded(LoadMovieEvent event) {
//        Log.d("a", "onNewsLoaded : " + event.getMovieList().size());
//        mPopularMovieAdapter.setNewData(event.getMovieList());
//
//    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMovidDbLoaded(LoadMovieDbEvent event) {
        Log.d("a", "onMovieDbLoaded : " + event.getMovieDbList().size());
        mPopularMovieAdapter.setNewData(event.getMovieDbList());

    }


}

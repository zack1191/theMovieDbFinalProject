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
import com.hha.heinhtetaung.themoviedb.adapters.UpComingMovieAdapter;
import com.hha.heinhtetaung.themoviedb.contorller.UpComingDelegate;
import com.hha.heinhtetaung.themoviedb.data.Model.MovieModel;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.events.LoadMovieDbEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadUpcomingEvent;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpComingMovieFragment extends Fragment implements UpComingDelegate {
    private UpComingMovieAdapter mUpComingMovieAdapter;
    private UpComingDelegate mUpComingDelegate;

    @BindView(R.id.rv_upcoming_movie)
    RecyclerView rvUpcome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_upcoming_movie, container, false);
        ButterKnife.bind(this, view);

        setUpRecyclerView();
        MovieModel.getsObjInstance().loadUpcoming();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mUpComingDelegate = (UpComingDelegate) context;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void setUpRecyclerView() {
        mUpComingMovieAdapter = new UpComingMovieAdapter(this.getContext(), mUpComingDelegate);
        rvUpcome.setLayoutManager(new GridLayoutManager(this.getContext(), 3, GridLayoutManager.VERTICAL, false));
        rvUpcome.setAdapter(mUpComingMovieAdapter);
    }

    public static UpComingMovieFragment newInstance() {
        UpComingMovieFragment fragment = new UpComingMovieFragment();
        return fragment;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMovidDbLoaded(LoadUpcomingEvent event) {
        Log.d("a", "onMovieDbLoaded : " + event.getMovieDbList().size());
        mUpComingMovieAdapter.setNewData(event.getMovieDbList());

    }


    @Override
    public void onTapUpcomingItems(MovieDetailVo movieDBVo) {
        mUpComingDelegate.onTapUpcomingItems(movieDBVo);
    }

}

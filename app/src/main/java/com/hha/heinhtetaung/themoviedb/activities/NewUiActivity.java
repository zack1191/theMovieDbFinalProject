package com.hha.heinhtetaung.themoviedb.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.adapters.NowshowingAdapter;
import com.hha.heinhtetaung.themoviedb.adapters.PopularMovieAdapter;
import com.hha.heinhtetaung.themoviedb.adapters.UpComingMovieAdapter;
import com.hha.heinhtetaung.themoviedb.contorller.MovieDelegate;
import com.hha.heinhtetaung.themoviedb.contorller.UpComingDelegate;
import com.hha.heinhtetaung.themoviedb.data.Model.MovieModel;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.events.LoadMovieDbEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadNowShowingEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadUpcomingEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewUiActivity extends AppCompatActivity implements MovieDelegate, UpComingDelegate {

    private PopularMovieAdapter mPopularMovieAdapter;
    private MovieDelegate movieDelegate;
    private UpComingDelegate upComingDelegate;

    private UpComingMovieAdapter mUpComingMovieAdapter;
    private NowshowingAdapter mNowshowingAdapter;


    @BindView(R.id.rv_ui_popular)
    RecyclerView rvPopular;

    @BindView(R.id.rv_ui_upcome)
    RecyclerView rvUpcome;

    @BindView(R.id.rv_ui_now_showing)
    RecyclerView rvNowShowing;

    @BindView(R.id.ivSearch)
    ImageView ivSearch;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, NewUiActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ui);
        ButterKnife.bind(this, this);

        setupPopularRecyclerView();
        setupUpcomeRecyclerView();
        setupNowshowingRecyclerView();

        MovieModel.getsObjInstance().loadMovie();
        MovieModel.getsObjInstance().loadUpcoming();
        MovieModel.getsObjInstance().loadNowshowing();
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SearchActivity.newIntent(getApplicationContext()));
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void setupPopularRecyclerView() {

        mPopularMovieAdapter = new PopularMovieAdapter(this, this);
        rvPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvPopular.setAdapter(mPopularMovieAdapter);
        rvPopular.setHasFixedSize(true);

    }

    private void setupUpcomeRecyclerView() {
        mUpComingMovieAdapter = new UpComingMovieAdapter(this, this);
        rvUpcome.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvUpcome.setAdapter(mUpComingMovieAdapter);
        rvUpcome.setHasFixedSize(true);
    }

    private void setupNowshowingRecyclerView() {
        mNowshowingAdapter = new NowshowingAdapter(this, this);
        rvNowShowing.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNowShowing.setAdapter(mNowshowingAdapter);
        rvNowShowing.setHasFixedSize(true);

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMovidDbLoaded(LoadMovieDbEvent event) {
        Log.d("a", "onMovieDbLoaded : " + event.getMovieDbList().size());
        mPopularMovieAdapter.setNewData(event.getMovieDbList());

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMovidDbLoaded(LoadUpcomingEvent event) {
        Log.d("a", "onMovieDbLoaded : " + event.getMovieDbList().size());
        mUpComingMovieAdapter.setNewData(event.getMovieDbList());

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMovidDbLoaded(LoadNowShowingEvent event) {
        Log.d("a", "onMovieDbLoaded : " + event.getMovieDbList().size());
        mNowshowingAdapter.setNewData(event.getMovieDbList());

    }


    @Override
    public void onTapMovieItems(MovieDetailVo tapMovie) {
        Toast.makeText(this, tapMovie.getmTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = MovieDetailActivity.newIntent(getApplicationContext(), tapMovie.getmId());
        startActivity(intent);
    }

    @Override
    public void onTapNowShowing(MovieDetailVo tapNowShowing) {
        Toast.makeText(this, tapNowShowing.getmTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = MovieDetailActivity.newIntent(getApplicationContext(), tapNowShowing.getmId());
        startActivity(intent);
    }


    @Override
    public void onTapUpcomingItems(MovieDetailVo movieDBVo) {
        Toast.makeText(this, movieDBVo.getmTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = MovieDetailActivity.newIntent(getApplicationContext(), movieDBVo.getmId());
        startActivity(intent);
    }
}

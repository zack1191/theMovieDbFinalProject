package com.hha.heinhtetaung.themoviedb.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.adapters.ReviewAdapter;
import com.hha.heinhtetaung.themoviedb.adapters.TrailerAdapter;
import com.hha.heinhtetaung.themoviedb.contorller.TrailerDelegate;
import com.hha.heinhtetaung.themoviedb.data.Model.MovieModel;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.data.VO.ReviewsVo;
import com.hha.heinhtetaung.themoviedb.data.VO.TrailerVo;
import com.hha.heinhtetaung.themoviedb.events.LoadNowShowingEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadReviewEvent;
import com.hha.heinhtetaung.themoviedb.events.LoadTrailerEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class MovieDetailActivity extends AppCompatActivity implements TrailerDelegate {

    @BindView(R.id.iv_manga)
    ImageView ivBackground;

    @BindView(R.id.tvOverView)
    TextView tvOverView;

    @BindView(R.id.tv_release_date)
    TextView tvReleaseDate;

    @BindView(R.id.tv_Tile)
    TextView tvTitle;

    @BindView(R.id.iv_close)
    ImageView ivClose;

    @BindView(R.id.iv_blur_image)
    ImageView ivBlurImage;

    @BindView(R.id.blurLayout)
    BlurView blurView;

    @BindView(R.id.tvPopularity)
    TextView tvPopular;

    @BindView(R.id.tvVote)
    TextView tvVote;

    @BindView(R.id.tv_trailer)
    TextView tvTrailer;

    @BindView(R.id.rv_trailers)
    RecyclerView rvTrailers;

    @BindView(R.id.tv_trailer_error)
    TextView tvTrailerError;

    @BindView(R.id.rv_review)
    RecyclerView rvReview;

    private String mMovieId;
    private long mId;

    public MovieDetailVo mMovieDB;

    private TrailerVo mTrailer;
    private TrailerAdapter mTrailerAdapter;
    private List<TrailerVo> mTrailerVoList;
    public static final String BASE_YOTUBE_URL = "http://www.youtube.com/watch?v=";

    private ReviewAdapter mReviewAdapter;

    public static Intent newIntent(Context context, String movieId) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra("movieId", movieId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this, this);

        Window w = getWindow(); // in Activity's onCreate() for instance
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        mTrailerVoList = new ArrayList<>();
        mMovieId = getIntent().getStringExtra("movieId");
        MovieModel.getsObjInstance().loadMovie();
        mMovieDB = MovieModel.getsObjInstance().getMovieDbById(mMovieId);


        displayMovieDetail(mMovieDB);
        setUpTrailerRecylerview();
        setUpReviewRecyclerView();

        MovieModel.getsObjInstance().loadTrailer(this, mMovieId);
        MovieModel.getsObjInstance().loadReview(mMovieId);
//        displayTrialer(mMovieDB);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        blurBackground();


    }

    private void displayMovieReview() {

    }


    private void blurBackground() {
        float radius = 22f;
        View decorView = getWindow().getDecorView();
        ViewGroup rootView = decorView.findViewById(android.R.id.content);
        Drawable windowbackground = decorView.getBackground();
        blurView.setupWith(rootView)
                .setFrameClearDrawable(windowbackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setHasFixedTransformationMatrix(true);
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

    @SuppressLint("SetTextI18n")
    private void displayMovieDetail(MovieDetailVo movieVo) {
        movieVo = mMovieDB;
        if (movieVo.getmPosterPath() != null) {
            ivBackground.setVisibility(View.VISIBLE);
            Glide.with(ivBackground.getContext())
                    .load("http://image.tmdb.org/t/p/original" + movieVo.getmPosterPath())
                    .into(ivBackground);
        } else {
            ivBackground.setVisibility(View.GONE);
        }
        if (movieVo.getmPosterPath() != null) {
            ivBlurImage.setVisibility(View.VISIBLE);
            Glide.with(ivBlurImage.getContext())
                    .load("http://image.tmdb.org/t/p/original" + movieVo.getmPosterPath())
                    .into(ivBlurImage);
        } else {
            ivBlurImage.setVisibility(View.GONE);
        }
        tvReleaseDate.setText(movieVo.getmReleaseDate());
        tvOverView.setText(movieVo.getmOverview());
        tvTitle.setText(movieVo.getmTitle());
        tvPopular.setText(movieVo.getmPopularity().toString());
        tvVote.setText(movieVo.getmVoteAverage().toString());


    }

    private void setUpTrailerRecylerview() {

        mTrailerAdapter = new TrailerAdapter(this, this);
        rvTrailers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvTrailers.setItemAnimator(new DefaultItemAnimator());
        rvTrailers.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        rvTrailers.setAdapter(mTrailerAdapter);
        rvTrailers.setHasFixedSize(true);
        mTrailerAdapter.notifyDataSetChanged();

    }

    private void setUpReviewRecyclerView() {
        mReviewAdapter = new ReviewAdapter(getApplicationContext());
        rvReview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvReview.setAdapter(mReviewAdapter);
        rvReview.setHasFixedSize(true);
        mReviewAdapter.notifyDataSetChanged();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMovidDbLoaded(LoadTrailerEvent event) {

        mTrailerAdapter.setNewData(event.getMovieDbList());

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReviewLoaded(LoadReviewEvent event) {

        mReviewAdapter.setNewData(event.getMovieDbList());

    }

    @Override
    public void onTapMovieTrailer(TrailerVo trailerVo) {
        Toast.makeText(this, trailerVo.getmName(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(BASE_YOTUBE_URL + trailerVo.getmKey())));
    }
}

package com.hha.heinhtetaung.themoviedb.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.data.Model.MovieModel;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;

import butterknife.BindView;
import butterknife.ButterKnife;
import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class UpcomingActivity extends AppCompatActivity {
    @BindView(R.id.tv_Tile_upc)
    TextView tvTitle;

    @BindView(R.id.iv_manga_upc)
    ImageView ivBackground;

    @BindView(R.id.tvDesc_upc)
    TextView tvOverView;

    @BindView(R.id.tv_release_date_upc)
    TextView tvReleaseDate;

    @BindView(R.id.iv_close_up)
    ImageView ivCloseUpcome;

    @BindView(R.id.iv_blur_image_upcome)
    ImageView ivBlurUpcome;

    @BindView(R.id.blurLayoutUpcome)
    BlurView blurView;

    @BindView(R.id.tvPopularityUpCome)
    TextView tvPopularUpcome;

    @BindView(R.id.tvVoteUpCome)
    TextView tvVoteUpCome;


    private MovieDetailVo mMovieDB;

    public static Intent newIntent(Context context, String movieId) {
        Intent intent = new Intent(context, UpcomingActivity.class);
        intent.putExtra("movieId", movieId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        ButterKnife.bind(this, this);

        Window w = getWindow(); // in Activity's onCreate() for instance
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        String mMovieId = getIntent().getStringExtra("movieId");

        MovieModel.getsObjInstance().loadMovie();
        mMovieDB = MovieModel.getsObjInstance().getMovieDbById(mMovieId);

        displayMovieDetail(mMovieDB);
        ivCloseUpcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        blurBackground();
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

    private void displayMovieDetail(MovieDetailVo mMovieDB) {
        if (mMovieDB.getmPosterPath() != null) {
            ivBackground.setVisibility(View.VISIBLE);
            Glide.with(ivBackground.getContext())
                    .load("http://image.tmdb.org/t/p/original" + mMovieDB.getmPosterPath())
                    .into(ivBackground);
        } else {
            ivBackground.setVisibility(View.GONE);
        }
        if (mMovieDB.getmPosterPath() != null) {
            ivBlurUpcome.setVisibility(View.VISIBLE);
            Glide.with(ivBlurUpcome.getContext())
                    .load("http://image.tmdb.org/t/p/original" + mMovieDB.getmPosterPath())
                    .into(ivBlurUpcome);
        } else {
            ivBlurUpcome.setVisibility(View.GONE);
        }
        tvReleaseDate.setText(mMovieDB.getmReleaseDate());
        tvOverView.setText(mMovieDB.getmOverview());
        tvTitle.setText(mMovieDB.getmTitle());
        tvPopularUpcome.setText(mMovieDB.getmPopularity().toString());
        tvVoteUpCome.setText(mMovieDB.getmVoteAverage().toString());
    }
}

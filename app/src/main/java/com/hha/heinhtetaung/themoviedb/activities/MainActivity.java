package com.hha.heinhtetaung.themoviedb.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hha.heinhtetaung.themoviedb.R;

import com.hha.heinhtetaung.themoviedb.contorller.MovieDelegate;
import com.hha.heinhtetaung.themoviedb.contorller.UpComingDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDBVo;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.fragments.HomePagerFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MovieDelegate, UpComingDelegate {


    private View snackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        showHome();

    }

    private void showHome() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_pager, HomePagerFragment.newInstance())
                .commit();
    }

    @Override
    public void onTapMovieItems(MovieDetailVo tapMovie) {
        Toast.makeText(this, tapMovie.getmTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = MovieDetailActivity.newIntent(getApplicationContext(), tapMovie.getmId());
        startActivity(intent);
    }

    @Override
    public void onTapNowShowing(MovieDetailVo tapNowShowing) {

    }


    @Override
    public void onTapUpcomingItems(MovieDetailVo tapUpcoming) {
        Toast.makeText(this, tapUpcoming.getmTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = UpcomingActivity.newIntent(getApplicationContext(), tapUpcoming.getmId());
        startActivity(intent);
    }


//    @Override
//    public void onTapMovieItems(MovieVo tapMovie) {
//        Toast.makeText(this, tapMovie.getTitle(), Toast.LENGTH_SHORT).show();
//        Intent intent = MovieDetailActivity.newIntent(getApplicationContext(), tapMovie.getId());
//        startActivity(intent);
//
//    }


}

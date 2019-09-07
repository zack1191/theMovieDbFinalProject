package com.hha.heinhtetaung.themoviedb.activities;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.adapters.SearchAdapter;
import com.hha.heinhtetaung.themoviedb.contorller.SearchMovieDelegate;
import com.hha.heinhtetaung.themoviedb.data.Model.MovieModel;
import com.hha.heinhtetaung.themoviedb.data.VO.MovieDetailVo;
import com.hha.heinhtetaung.themoviedb.events.LoadSearchMovieEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity implements View.OnKeyListener, SearchMovieDelegate {
    @BindView(R.id.ib_back)
    ImageView ivBack;

    @BindView(R.id.ib_close)
    ImageView ivClose;

    @BindView(R.id.edt_search)
    EditText etSearch;

    @BindView(R.id.rv_search_results)
    RecyclerView rvSearchResults;

    private SearchAdapter mSearchAdapter;


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this, this);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etSearch.setText("");
                mSearchAdapter.clearData();
            }
        });

        mSearchAdapter = new SearchAdapter(getApplicationContext(), this);
        rvSearchResults.setLayoutManager(new GridLayoutManager(this, 3));
        rvSearchResults.setItemAnimator(new DefaultItemAnimator());
        rvSearchResults.setAdapter(mSearchAdapter);

        etSearch.setOnKeyListener(this);

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

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {

            String query = etSearch.getText().toString().trim();
            if (!TextUtils.isEmpty(query)) {

                MovieModel.getsObjInstance().loadSearchMovies(query);

                InputMethodManager imm = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(etSearch.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }

            return true;
        }

        return true;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LoadSearchMovieEvent event) {
        List<MovieDetailVo> searchResult = event.getMovieDbList();
        if (searchResult.size() > 0) {
            mSearchAdapter.appendNewData(event.getMovieDbList());
        } else {
            Toast.makeText(this, "Movie not found!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onTapSearchMovie(MovieDetailVo movieDetailVo) {
        Toast.makeText(this, movieDetailVo.getmTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = MovieDetailActivity.newIntent(getApplicationContext(), movieDetailVo.getmId());
        startActivity(intent);
    }
}

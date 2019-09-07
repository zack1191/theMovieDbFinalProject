package com.hha.heinhtetaung.themoviedb.fragments;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.adapters.HomePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePagerFragment extends Fragment {

    @BindView(R.id.pager_home)
    ViewPager mPager;

    @BindView(R.id.tl_home)
    TabLayout tlHome;

    private HomePagerAdapter homePagerAdapter;

    public static HomePagerFragment newInstance() {
        return new HomePagerFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homePagerAdapter = new HomePagerAdapter(getActivity().getSupportFragmentManager());
        homePagerAdapter.addTab(PopularMovieFragment.newInstance(), getString(R.string.popular));
        homePagerAdapter.addTab(UpComingMovieFragment.newInstance(), getString(R.string.upcoming));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_pager, container, false);
        ButterKnife.bind(this, rootView);

        mPager.setAdapter(homePagerAdapter);
        mPager.setOffscreenPageLimit(homePagerAdapter.getCount());
        tlHome.setupWithViewPager(mPager);

        setupTabIcons();
        tlHome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }

    public static class TabLayoutChangedEvent {
        private String title;

        public TabLayoutChangedEvent(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    private void setupTabIcons() {

        TextView tabCinema = (TextView) LayoutInflater.from(this.getContext()).inflate(R.layout.custom_tab, null);
        tabCinema.setText(getString(R.string.popular));
        tabCinema.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_movie_filter_red_24dp, 0, 0);
        tlHome.getTabAt(0).setCustomView(tabCinema);

        TextView tabNowShowing = (TextView) LayoutInflater.from(this.getContext()).inflate(R.layout.custom_tab, null);
        tabNowShowing.setText(getString(R.string.upcoming));
        tabNowShowing.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_local_movies_red_24dp, 0, 0);
        tlHome.getTabAt(1).setCustomView(tabNowShowing);

    }

}

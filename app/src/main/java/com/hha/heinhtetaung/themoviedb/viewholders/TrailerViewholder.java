package com.hha.heinhtetaung.themoviedb.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.contorller.TrailerDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.TrailerVo;

import java.util.List;

import butterknife.BindView;

public class TrailerViewholder extends BaseViewHolder<TrailerVo> {

    @BindView(R.id.iv_trailer_preview)
    ImageView ivTrailerPreview;

    @BindView(R.id.tvTrailerTitle)
    TextView tvTrailerTitle;

    private TrailerDelegate mTrailerDelegate;

    private TrailerVo mTrailer;

    public TrailerViewholder(View itemView, TrailerDelegate trailerDelegate) {
        super(itemView);
        this.mTrailerDelegate = trailerDelegate;
    }

    @Override
    public void setData(TrailerVo data) {
        mTrailer = data;
        tvTrailerTitle.setText(mTrailer.getmName());
        Glide.with(ivTrailerPreview.getContext())
                .load(data.getTrailerPath())
                .thumbnail(0.1f)
                .into(ivTrailerPreview);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        mTrailerDelegate.onTapMovieTrailer(mTrailer);
    }
}





package com.hha.heinhtetaung.themoviedb.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.data.VO.ReviewsVo;
import com.hha.heinhtetaung.themoviedb.viewholders.ReviewViewholder;
import com.hha.heinhtetaung.themoviedb.viewholders.TrailerViewholder;

public class ReviewAdapter extends BaseRecyclerAdapter<ReviewViewholder, ReviewsVo> {

    public ReviewAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ReviewViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_review, parent, false);
        return new ReviewViewholder(view);
    }

}

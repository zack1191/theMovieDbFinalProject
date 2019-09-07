package com.hha.heinhtetaung.themoviedb.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.contorller.TrailerDelegate;
import com.hha.heinhtetaung.themoviedb.data.VO.TrailerVo;
import com.hha.heinhtetaung.themoviedb.viewholders.TrailerViewholder;

import java.util.List;

public class TrailerAdapter extends BaseRecyclerAdapter<TrailerViewholder, TrailerVo> {

    private List<TrailerVo> mTrailerVoList;
    private TrailerDelegate mTrailerDelegate;

    public TrailerAdapter(Context context, TrailerDelegate trailerDelegate) {
        super(context);
        mTrailerDelegate = trailerDelegate;
    }

    @NonNull
    @Override
    public TrailerViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_trailer, parent, false);
        return new TrailerViewholder(view, mTrailerDelegate);
    }

    public void setData(List<TrailerVo> trailerVos) {
        mTrailerVoList = trailerVos;
        notifyDataSetChanged();

    }

}

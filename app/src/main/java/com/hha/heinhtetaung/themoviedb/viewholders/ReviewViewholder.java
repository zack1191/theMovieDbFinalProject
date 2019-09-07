package com.hha.heinhtetaung.themoviedb.viewholders;

import android.view.View;
import android.widget.TextView;

import com.hha.heinhtetaung.themoviedb.R;
import com.hha.heinhtetaung.themoviedb.data.VO.ReviewsVo;

import butterknife.BindView;

public class ReviewViewholder extends BaseViewHolder<ReviewsVo> {

    @BindView(R.id.tv_author)
    TextView tvAuthor;

    @BindView(R.id.tv_content)
    TextView tvContent;

    public ReviewsVo mReviewsVo;

    public ReviewViewholder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(ReviewsVo data) {
        mReviewsVo = data;
        tvAuthor.setText(data.getAuthor());
        tvContent.setText(data.getContent());
    }
}

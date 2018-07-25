package com.example.nicholas.cinebox.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nicholas.cinebox.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.movie_pg)
    TextView mPG;
    @BindView(R.id.details)
    TextView mDetails;
    @BindView(R.id.movie_image)
    ImageView mImage;
    @BindView(R.id.movie_background)
    ImageView mBackGround;
    @BindView(R.id.release_date)
    TextView mReleaseDate;
    @BindView(R.id.duration)
    TextView mDuration;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addToolbar();

        /**
         * You can add more here depending on the intents passed from MoviesAdapter
         * */

         Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mTitle.setText(bundle.getString("title"));
            mPG.setText(bundle.getString("pg"));
            mDetails.setText(bundle.getString("description"));
            mReleaseDate.setText(bundle.getString("release_date"));
            mDuration.setText(bundle.getString("duration"));
            Glide.with(this).load(bundle.getString("image")).into(mImage);
            Glide.with(this).load(bundle.getString("background")).into(mBackGround);
        }
    }
}

package com.example.nicholas.cinebox.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.example.nicholas.cinebox.R;

public class DetailActivity extends BaseActivity {

  /*@BindView(R.id.title)
  TextView mTitle;*/
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
  @BindView(R.id.movie_genre)
  TextView mGenre;
  @BindView(R.id.lang)
  TextView mLang;
  @BindView(R.id.watch_trailer)
  Button mTrailer;
  @BindView(R.id.movie_rating)
  TextView mRating;


  @Override
  protected int getLayoutRes() {
    return R.layout.activity_detail;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    addToolbar();

    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      //mTitle.setText(bundle.getString("title"));
      mPG.setText(bundle.getString("pg"));
      mDetails.setText(bundle.getString("description"));
      mReleaseDate.setText(bundle.getString("release_date"));
      mDuration.setText(bundle.getString("duration"));
      mToolbar.setTitle(bundle.getString("title"));
      mGenre.setText(bundle.getString("genre"));
      mLang.setText(bundle.getString("language"));
      mRating.setText(bundle.getString("rating"));
      Glide.with(this).load(bundle.getString("image")).into(mImage);
      Glide.with(this).load(bundle.getString("background")).into(mBackGround);
      mTrailer.setOnClickListener(v -> {
        String uri = bundle.getString("trailer");
        Intent trailer = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(trailer);
      });
    }
  }
}

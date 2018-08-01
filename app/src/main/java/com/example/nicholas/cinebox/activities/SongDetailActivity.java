package com.example.nicholas.cinebox.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.nicholas.cinebox.R;
import es.dmoral.toasty.Toasty;

/*
 * Created by Mbuodile Obiosio on 7/31/18
 * cazewonder@gmail.com
 * https://twtter.com/cazewonder
 */
public class SongDetailActivity extends BaseActivity {

  @Override
  protected int getLayoutRes() {
    return R.layout.activity_song_detail;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    addToolbar();

    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      Toasty.info(this, bundle.getString("title")).show();
    }
  }


}

package com.example.nicholas.cinebox;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.nicholas.cinebox.activities.WelcomeActivity;
import com.example.nicholas.cinebox.fragments.FavoritesFragment;
import com.example.nicholas.cinebox.fragments.HomeFragment;
import com.example.nicholas.cinebox.fragments.MusicFragment;
import com.example.nicholas.cinebox.model.MusicModel;
import com.example.nicholas.cinebox.utils.Constants;
import com.example.nicholas.cinebox.utils.SongCollection;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;

public class MainActivity extends AppCompatActivity implements
    NavigationView.OnNavigationItemSelectedListener {


  @BindView(R.id.drawer_layout)
  DrawerLayout mDrawerLayout;
  @BindView(R.id.nav_view)
  NavigationView mNavigationView;
  @BindView(R.id.toolbar)
  Toolbar mToolbar;
  ActionBarDrawerToggle mToggle;

  FragmentManager mFragmentManager;
  FragmentTransaction mFragmentTransaction;

  public int mNavItemId;
  boolean navMenuFirst = true;
  private boolean isLoggedIn = false;

  private SongCollection songCollection = new SongCollection();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    setSupportActionBar(mToolbar);

    if (savedInstanceState != null) {
      mNavItemId = savedInstanceState.getInt(Constants.NAV_ITEM_ID);
      navMenuFirst = savedInstanceState.getBoolean(Constants.NAV_MENU_VIEW);
    } else {
      mNavItemId = R.id.nav_watchlist;
    }

    mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open,
        R.string.close);

    mDrawerLayout.addDrawerListener(mToggle);
    mToggle.syncState();

    mFragmentManager = getSupportFragmentManager();
    mFragmentTransaction = mFragmentManager.beginTransaction();
    mFragmentTransaction.replace(R.id.containerView, new HomeFragment()).commit();

    mNavigationView.setNavigationItemSelectedListener(this);

  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    mToggle.onConfigurationChanged(newConfig);
  }

  @Override
  public void onBackPressed() {
    if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
      mDrawerLayout.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    outState.putInt(Constants.NAV_ITEM_ID, mNavItemId);
    outState.putBoolean(Constants.NAV_MENU_VIEW, navMenuFirst);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.nav_home) {
      mFragmentTransaction = mFragmentManager.beginTransaction();
      mFragmentTransaction.replace(R.id.containerView, new HomeFragment())
          .addToBackStack(Constants.NAV_ITEM_ID).commit();
    } else if (id == R.id.nav_music) {
      mFragmentTransaction = mFragmentManager.beginTransaction();
      mFragmentTransaction.replace(R.id.containerView, MusicFragment.newInstance()).commit();
    } else if (id == R.id.nav_favorites) {
      mFragmentTransaction = mFragmentManager.beginTransaction();
      mFragmentTransaction.replace(R.id.containerView, FavoritesFragment.newInstance()).commit();
    }
    mDrawerLayout.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override
  protected void onResume() {
    super.onResume();
    isLoggedIn = Constants.getLoggedInUserPref();
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    MenuItem item = menu.findItem(R.id.logout);
    if (isLoggedIn) {
      item.setVisible(true);
    } else {
      item.setVisible(false);
    }
    return true;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu, menu);
        /*SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(queryTextListener);*/
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.logout:
        logout();
        break;
      default:
        break;
    }
    return super.onOptionsItemSelected(item);
  }

  private SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {
      //if you need this
      return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
      //your code
      return true;
    }
  };

  public void logout() {
    new MaterialStyledDialog.Builder(this)
        .setTitle(getString(R.string.logout_title))
        .setStyle(Style.HEADER_WITH_ICON)
        .setIcon(R.drawable.ic_thumb_down)
        .setDescription(getString(R.string.logout_dialog))
        .setPositiveText(R.string.yes)
        .setNegativeText(getString(R.string.no))
        .onPositive((dialog, which) -> {
          Constants.storeLoggedInUserPref(false);
          Constants.storeUser("");
          Intent intent = new Intent(this, WelcomeActivity.class);
          intent.putExtra("finish", true);
          intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
              Intent.FLAG_ACTIVITY_CLEAR_TASK |
              Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);
          finish();
        })
        .show();
  }


  public void handleSelection(View view) {
    String resourceId = this.getResources().getResourceEntryName(view.getId());
    MusicModel selectedSong = songCollection.searchById(resourceId);
    sendDataToActivity(selectedSong);
  }

  public void sendDataToActivity(MusicModel song) {
    Intent intent = new Intent(this, PlaySong.class);

    intent.putExtra("id", song.getId());
    intent.putExtra("title", song.getTitle());
    intent.putExtra("artist", song.getArtist());
    intent.putExtra("fileLink", song.getFileLink());
    intent.putExtra("coverArt", song.getCoverArt());

    startActivity(intent);

  }
}

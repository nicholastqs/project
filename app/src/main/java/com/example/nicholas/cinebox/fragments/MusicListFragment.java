package com.example.nicholas.cinebox.fragments;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.nicholas.cinebox.R;
import com.example.nicholas.cinebox.activities.SongDetailActivity;
import com.example.nicholas.cinebox.adapter.MusicAdapter;
import com.example.nicholas.cinebox.model.MusicModel;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass. Use the {@link MusicListFragment#newInstance} factory method
 * to create an instance of this fragment.
 */


public class MusicListFragment extends BaseFragment {

  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  private String mParam1;
  private String mParam2;


   @BindView(R.id.recycler_view)
   RecyclerView recyclerView;


  private MusicAdapter mAdapter;

  private ArrayList<MusicModel> modelList = new ArrayList<>();


  public MusicListFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of this fragment using the provided
   * parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment MusicListFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static MusicListFragment newInstance(String param1, String param2) {
    MusicListFragment fragment = new MusicListFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  public static MusicListFragment newInstance() {
    MusicListFragment fragment = new MusicListFragment();
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);

    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    mView = super.onCreateView(inflater, container, savedInstanceState);
    //ButterKnife.bind(this, view);

    return mView;

  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    setAdapter();


  }


  private void setAdapter() {

    modelList.add(new MusicModel("1", "Welcome To The Party Remix", "Lil Pump, Diplo, French Montana", "ee5a4fb3166dbaa517726b9fe5e70b54714272d8?cid=2afe87a64b0042dabf51f37318616965", 4.39, "deadpool"));

    mAdapter = new MusicAdapter(getActivity(), modelList);

    recyclerView.setHasFixedSize(true);

    // use a linear layout manager
    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);

    recyclerView.setAdapter(mAdapter);

    mAdapter.SetOnItemClickListener((view, position, model) -> {

      //handle item click events here
      setIntent(model);

    });
  }
  private void setIntent(MusicModel model) {
    Intent intent = new Intent(getActivity(), SongDetailActivity.class);
    intent.putExtra("title", model.getTitle());
    startActivity(intent);
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_music_list;
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.music_menu, menu);

    // Associate searchable configuration with the SearchView
    SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
    SearchView searchView =
        (SearchView) menu.findItem(R.id.search).getActionView();
    // Assumes current activity is the searchable activity
    if (searchManager != null) {
      searchView.setSearchableInfo(
          searchManager.getSearchableInfo(getActivity().getComponentName())
      );
    }
    searchView.setIconifiedByDefault(false);
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String s) {
        // Takes care of dismissing the keyboard when search is performed
        searchView.clearFocus();
        return false;
      }

      @Override
      public boolean onQueryTextChange(String s) {
        return false;
      }
    });

    super.onCreateOptionsMenu(menu, inflater);
  }
}

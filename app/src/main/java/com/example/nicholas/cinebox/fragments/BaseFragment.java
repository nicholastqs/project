package com.example.nicholas.cinebox.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * Created by Mbuodile Obiosio on 8/1/18
 * cazewonder@gmail.com
 * https://twtter.com/cazewonder
 */
public abstract class BaseFragment extends Fragment {

  View mView;
  private Unbinder mUnbinder;
  protected Context mContext;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mContext = getActivity();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    mView = LayoutInflater.from(getContext()).inflate(getLayoutId(), container, false);
    mUnbinder = ButterKnife.bind(this, mView);

    return mView;
  }

  @Override
  public void onAttach(Context context) {
    this.mContext = context;
    super.onAttach(context);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mUnbinder.unbind();
  }

  protected abstract
  @LayoutRes
  int getLayoutId();
}

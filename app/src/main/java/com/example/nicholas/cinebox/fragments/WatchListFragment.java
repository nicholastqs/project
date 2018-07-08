package com.example.nicholas.cinebox.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nicholas.cinebox.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WatchListFragment extends Fragment {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    View mView;

    public WatchListFragment() {
        // Required empty public constructor
    }


    public static WatchListFragment newInstance() {
        WatchListFragment fragment = new WatchListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_watchlist, container, false);
        ButterKnife.bind(this, mView);

        mViewPager.setAdapter(new FragmentsAdapter(getChildFragmentManager(), getActivity()));

        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
        });

        return mView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    private class FragmentsAdapter extends FragmentStatePagerAdapter {
        /*You can get Tab Titles using this implementation. However doing this is not recommended for localisation of your app*/
        private String frags[] = {"SECTION 1", "SECTION 2", "SECTION 3", "SECTION 4"};

        /*The better way to do this getting your titles as arrays*/
        //private String title[] = getActivity().getResources().getStringArray(R.array.tab_titles);

        public FragmentsAdapter(FragmentManager supportFragmentManager, Context context) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new SectionOneFragment();
                case 1:
                    return new SectionTwoFragment();
                case 2:
                    return new SectionThreeFragment();
                case 3:
                    return new SectionFourFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            /*Depending on which string array you're using, you choose here*/
            return frags.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            /*Same for here too if you want to using stringarrays from resources*/
            return frags[position];
        }
    }
}

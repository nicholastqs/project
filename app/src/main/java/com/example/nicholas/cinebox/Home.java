package com.example.nicholas.cinebox;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Home extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mToolbar;

    private Home.SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mSectionsPagerAdapter = new Home.SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private ImageButton imagedp;
        private ImageButton imagedp1;
        ImageButton imagejw;
        ImageButton imagejw1;
        ImageButton imagejw2;
        ImageButton imagejw3;
        ImageButton imagejw4;
        ImageButton imagejw5;
        ImageButton imagea;
        ImageButton imagea1;
        ImageButton imagea2;
        ImageButton imagea3;
        ImageButton imagea4;
        ImageButton imagea5;
        ImageButton imagea6;
        ImageButton imaget;
        ImageButton imaget1;
        ImageButton imagei;
        ImageButton imagei1;
        ImageButton imagei2;
        ImageButton imagei3;
        ImageButton imagei4;
        ImageButton imagei5;
        ImageButton imagek;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;
            switch(getArguments().getInt(ARG_SECTION_NUMBER))
            {
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_fragment1, container, false);
                    imagejw3 = (ImageButton) rootView.findViewById(R.id.imgjw4);
                    imagejw4 = (ImageButton) rootView.findViewById(R.id.imgjw5);
                    imagejw5 = (ImageButton) rootView.findViewById(R.id.imgjw6);
                    imagea4 = (ImageButton) rootView.findViewById(R.id.imga5);
                    imagea5 = (ImageButton) rootView.findViewById(R.id.imga6);
                    imagea6 = (ImageButton) rootView.findViewById(R.id.imga7);
                    imagei3 = (ImageButton) rootView.findViewById(R.id.imgi4);
                    imagei4 = (ImageButton) rootView.findViewById(R.id.imgi5);
                    imagei5 = (ImageButton) rootView.findViewById(R.id.imgi6);

                    imagejw3.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), JurassicWorld.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagejw4.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), JurassicWorld.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagejw5.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), JurassicWorld.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagea4.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Avengers.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagea5.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Avengers.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagea6.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Avengers.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagei3.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Incredibles2.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagei4.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Incredibles2.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagei5.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Incredibles2.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });


                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_fragment2, container, false);
                    imagejw2 = (ImageButton) rootView.findViewById(R.id.imgjw3);
                    imagea3 = (ImageButton) rootView.findViewById(R.id.imga4);
                    imagei2 = (ImageButton) rootView.findViewById(R.id.imgi3);

                    imagejw2.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), JurassicWorld.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });

                    imagea3.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Avengers.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });

                    imagei2.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Incredibles2.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });




                    break;
                    case 3:
                        rootView = inflater.inflate(R.layout.fragment_fragment3, container, false);
                        imagejw1 = (ImageButton) rootView.findViewById(R.id.imgjw2);
                        imagea2 = (ImageButton) rootView.findViewById(R.id.imga3);
                        imagei1 = (ImageButton) rootView.findViewById(R.id.imgi2);

                        imagejw1.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getActivity(), JurassicWorld.class);
                                ((Home) getActivity()).startActivity(intent);
                            }
                        });

                        imagea2.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getActivity(), Avengers.class);
                                ((Home) getActivity()).startActivity(intent);
                            }
                        });

                        imagei1.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getActivity(), Incredibles2.class);
                                ((Home) getActivity()).startActivity(intent);
                            }
                        });



                break;
                case 4:
                    rootView = inflater.inflate(R.layout.fragment_fragment4, container, false);
                    imagedp = (ImageButton) rootView.findViewById(R.id.imgdp1);
                    imagedp1 = (ImageButton) rootView.findViewById(R.id.imgdp2);
                    imagejw = (ImageButton) rootView.findViewById(R.id.imgjw);
                    imagea = (ImageButton) rootView.findViewById(R.id.imga1);
                    imagea1 = (ImageButton) rootView.findViewById(R.id.imga2);
                    imaget = (ImageButton) rootView.findViewById(R.id.imgt1);
                    imaget1 = (ImageButton) rootView.findViewById(R.id.imgt2);
                    imagei = (ImageButton) rootView.findViewById(R.id.imgi);
                    imagek = (ImageButton) rootView.findViewById(R.id.imgk);



                    imagedp1.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Deadpool2.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagedp.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Deadpool2.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagejw.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), JurassicWorld.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagea1.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Avengers.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagea.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Avengers.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imaget.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Thor.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imaget1.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Thor.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });

                    imagei.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Incredibles2.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });
                    imagek.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), Kingsman.class);
                            ((Home) getActivity()).startActivity(intent);
                        }
                    });



                break;
            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
                case 4:
                    return "SECTION 4";
            }
            return null;
        }
    }
}

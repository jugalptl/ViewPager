package com.example.igroup.viewpager;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements MaterialTabListener {

    ViewPager mPager;
    private static final int NUM_PAGES = 3;
    private PagerAdapter mPagerAdapter;
    private FloatingActionButton email;
    private MaterialTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        mPager = (ViewPager) findViewById(R.id.pager);
        email = (FloatingActionButton) findViewById(R.id.fab);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        tabHost = (MaterialTabHost)findViewById(R.id.materialTabHost);
        mPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabHost.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        for(int i = 0; i<mPagerAdapter.getCount();i++){
            tabHost.addTab(tabHost.newTab().setText(mPagerAdapter.getPageTitle(i)).setTabListener(MainActivity.this));
        }


        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throw new RuntimeException("This is crash");
            }
        });
        /*@Override
        public void onBackPressed() {
            if (mPager.getCurrentItem() == 0) {
                // If the user is currently looking at the first step, allow the system to handle the
                // Back button. This calls finish() on this activity and pops the back stack.
                super.onBackPressed();
            } else {
                // Otherwise, select the previous step.
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            }
        }*/

        /**
         * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
         * sequence.
         */
    }

    @Override
    public void onTabSelected(MaterialTab tab) {
        mPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }

    class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
           String[] tabs;
            public ScreenSlidePagerAdapter(FragmentManager fm) {
                super(fm);
                tabs = getResources().getStringArray(R.array.tabs);
            }

            @Override
            public Fragment getItem(int position) {
                return MyFragment.newInstance(String.valueOf(position +1),MainActivity.this);
            }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
            public int getCount() {
                return NUM_PAGES;
            }
        }
    }


/*
    }



    public List<Fragment> getFragments(Context context) {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(MyFragment.newInstance("1", context));
        fList.add(MyFragment.newInstance("2", context));
        fList.add(MyFragment.newInstance("3", context));
        fList.add(MyFragment.newInstance("4", context));
        fList.add(MyFragment.newInstance("5", context));
        fList.add(MyFragment.newInstance("6", context));
        fList.add(MyFragment.newInstance("7", context));
        return fList;

    }
}
*/



/*
class MyPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}*/

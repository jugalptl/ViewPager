package com.example.igroup.viewpager;



import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.crashlytics.android.Crashlytics;
import com.example.igroup.viewpager.Network.AppController;
import com.example.igroup.viewpager.Network.CheckNetwork;
import com.example.igroup.viewpager.Network.VolleySingleton;
import com.example.igroup.viewpager.Pojo.Clients;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.fabric.sdk.android.Fabric;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends FragmentActivity implements MaterialTabListener {

    ViewPager mPager;
    private static final int NUM_PAGES = 3;
    private PagerAdapter mPagerAdapter;
    private FloatingActionButton email;
    private MaterialTabHost tabHost;
    VolleySingleton volleySingleton;
    RequestQueue requestQueue;
    String tabs[];


    ArrayList<Clients> clientArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Fabric fabric = new Fabric.Builder(this).debuggable(true).kits(new Crashlytics(), new CrashlyticsNdk()).build();

        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        Fresco.initialize(this);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);



                try {

                    sendJsonRequesr();
            }catch (Exception e)
            {
                System.out.println(e.toString());
            }



    }


    private void setTabInfo() {

        mPager = (ViewPager) findViewById(R.id.pager);
        email = (FloatingActionButton) findViewById(R.id.fab);
       // mPager = (ViewPager) findViewById(R.id.pager);

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());

        mPagerAdapter.notifyDataSetChanged();
        mPager.setAdapter(mPagerAdapter);
        tabHost = (MaterialTabHost)findViewById(R.id.materialTabHost);
       /* for(int i = 0; i<mPagerAdapter.getCount();i++){
            tabHost.addTab(tabHost.newTab().setText(mPagerAdapter.getPageTitle(i)).setTabListener(MainActivity.this));
        }*/

        for (int i = 0; i < tabs.length; i++) {
            tabHost.addTab(
                    tabHost.newTab()
                            .setText(tabs[i])
                            .setTabListener(MainActivity.this)
            );

            System.out.println("55555555555555555555555555555555555555555555555555555555555555"+tabs[i]);
        }
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



        mPagerAdapter.notifyDataSetChanged();
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throw new RuntimeException("This is crash");
            }
        });
    }

    private void sendJsonRequesr() {
        JsonArrayRequest jsonArrayReq = new JsonArrayRequest(Request.Method.GET,"http://dev.trainerpl.us/api/v1/clients",null ,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                /** parse server response */
                clientArrayList = parseJSONResponse(response);
                setTabInfo();
            }




        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
               String auth1 = "Token 13cc2add9f14af86bc0a874be774153f94320fb7";
                //342e23dca28a376cd964e5acb50a5260eccda3b8
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("Authorization",auth1);
                return headers;
            }
        };


        AppController.getInstance().addToRequestQueue(jsonArrayReq);
    }

    private ArrayList<Clients> parseJSONResponse(JSONArray response) {

        ArrayList<Clients> clientDataList = new ArrayList<>();

        for(int i = 0; i< response.length();i++)
        {
            try {
                JSONObject currentClient = response.getJSONObject(i);

                String fname = "";
                String lname="";
                String email="";
                if(currentClient.has("first_name") && !currentClient.isNull("first_name"))
                {
                    fname = currentClient.getString("first_name");
                }
                if(currentClient.has("last_name") && !currentClient.isNull("last_name"))
                {
                     lname = currentClient.getString("last_name");
                }
                if(currentClient.has("email") && !currentClient.isNull("email"))
                {
                     email = currentClient.getString("email");
                }

                Clients newclient = new Clients();
                newclient.setFirstName(fname);
                newclient.setLastName(lname);
                newclient.setEmail(email);
                clientDataList.add(newclient);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    return clientDataList;
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
           //String[] tabs;
            public ScreenSlidePagerAdapter(FragmentManager fm) {
                super(fm);
                tabs = getResources().getStringArray(R.array.tabs);
            }

            @Override
            public Fragment getItem(int position) {
                return MyFragment.newInstance(String.valueOf(position +1),MainActivity.this,clientArrayList);
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




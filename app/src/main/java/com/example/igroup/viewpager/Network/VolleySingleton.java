package com.example.igroup.viewpager.Network;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by iGroup on 12/17/2016.
 */
public class VolleySingleton extends Application {

    private static  VolleySingleton mInstance = null;
    private RequestQueue requestQueue;
    private VolleySingleton()
    {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static VolleySingleton getInstance(){
        if(mInstance == null)
        {
            return mInstance = new VolleySingleton();
        }
        return mInstance;

    }
    public RequestQueue getRequestQueue()
    {
        return requestQueue;
    }


}

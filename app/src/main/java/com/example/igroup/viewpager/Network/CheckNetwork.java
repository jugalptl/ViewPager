package com.example.igroup.viewpager.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by iGroup on 3/18/2017.
 */
public class CheckNetwork {
    public static boolean isNetworkAvailable()
    {
        ConnectivityManager connection = (ConnectivityManager) AppController.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connection.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}

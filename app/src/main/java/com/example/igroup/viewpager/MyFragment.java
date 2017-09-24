package com.example.igroup.viewpager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.igroup.viewpager.Adapters.NameAdapter;
import com.example.igroup.viewpager.Pojo.Clients;

import org.w3c.dom.NameList;

import java.util.ArrayList;

/**
 * Created by iGroup on 3/18/2017.
 */
public class MyFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    static Context contxt;
    public static ArrayList<Clients> clientArrayList;

    public static MyFragment newInstance(String message, Context context, ArrayList<Clients> clientList) {
        contxt = context;
        clientArrayList = clientList;
        MyFragment f = new MyFragment();

        Bundle bdl = new Bundle();

        bdl.putString(EXTRA_MESSAGE, message);

        f.setArguments(bdl);

        return f;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
       // TextView txt = (TextView) rootView.findViewById(R.id.txt);

        String message = getArguments().getString(EXTRA_MESSAGE);

        RecyclerView nameList = (RecyclerView)rootView.findViewById(R.id.NameList);
        nameList.setLayoutManager(new LinearLayoutManager(getActivity()));
        NameAdapter mAdapter = new NameAdapter(getActivity(),clientArrayList);
        nameList.setAdapter(mAdapter);


        return rootView;
    }
}

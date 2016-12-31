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
 * Created by iGroup on 7/21/2016.
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
        /*switch(message)
        {
            case "1" :
                txt.setText("View Page 1");
                break;
            case "2" :
                txt.setText("View Page 2");
                break;
            case "3" :
                txt.setText("View Page 3");
                break;
            case "4" :
                txt.setText("View Page 4");
                break;
            case "5" :
                txt.setText("View Page 5");
                break;*/

            /*default:
                txt.setText("View Page 1");
                break;*/
        /*}*/
        RecyclerView nameList = (RecyclerView)rootView.findViewById(R.id.NameList);
        nameList.setLayoutManager(new LinearLayoutManager(getActivity()));
        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"+clientArrayList.toString());
        NameAdapter mAdapter = new NameAdapter(getActivity(),clientArrayList);
        nameList.setAdapter(mAdapter);


        return rootView;
        /*View v = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        ImageView image = (ImageView) v.findViewById(R.id.imageView);
        Button actionButton = (Button) v.findViewById(R.id.actionButton);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // callActivity(contxt);
            }
        });
        // load image

        Uri uri;
        switch (message) {
            case "1":
                uri = Uri.parse("assets:///slide1.png");
                break;
            case "2":
                uri = Uri.parse("assets:///slide2.png");
                break;
            case "3":
                uri = Uri.parse("assets:///slide3.png");
                break;
            case "4":
                uri = Uri.parse("assets:///slide4.png");
                break;
            case "5":
                uri = Uri.parse("assets:///slide5.png");
                break;
            case "6":
                uri = Uri.parse("assets:///slide6.png");
                break;
            case "7":
                uri = Uri.parse("assets:///slide7.png");
                actionButton.setBackgroundResource(R.drawable.skip);
                break;
            default:
                uri = Uri.parse("asset:///slide1.png");
                break;
        }
        image.setImageURI(uri);
        *///return v;
    }
}

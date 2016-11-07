package com.example.igroup.viewpager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by iGroup on 7/21/2016.
 */
public class MyFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    static Context contxt;

    public static MyFragment newInstance(String message, Context context) {
        contxt = context;
        MyFragment f = new MyFragment();

        Bundle bdl = new Bundle(1);

        bdl.putString(EXTRA_MESSAGE, message);

        f.setArguments(bdl);

        return f;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        String message = getArguments().getString(EXTRA_MESSAGE);
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

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

package com.gl.app.fragment;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gl.app.R;


public class ApplicationInfoFragment extends Fragment {
    TextView textView, textName, textVersion;
    String name;
    int version;
    public static final String EXTRA_MESSAGE = "Application";

    public ApplicationInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ApplicationInfo app = getActivity().getApplicationInfo();
        name = app.packageName;
        version = app.targetSdkVersion;

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_application_info, container, false);
        textView = view.findViewById(R.id.appId);
        textName = view.findViewById(R.id.appName);
        textVersion = view.findViewById(R.id.appversion);


        String message = getArguments().getString(EXTRA_MESSAGE);

        textView.setText(message);
        textName.setText(name);
        //    textVersion.setText(String.valueOf(app.minSdkVersion));
        return view;
    }


    public static final ApplicationInfoFragment newInstance(String message) {
        ApplicationInfoFragment f = new ApplicationInfoFragment();
        Bundle args = new Bundle();

        args.putString(EXTRA_MESSAGE, message);
        f.setArguments(args);
        return f;
    }
}

package com.gl.app.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gl.app.BuildConfig;
import com.gl.app.R;


public class ApplicationVersionFragment extends Fragment {
    TextView textView, textVersionName, textOsName, textVersionCode;
    static int code;
    static String versionName, osName, device;
    public static final String EXTRA_MESSAGE = "Version";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_application_version, container, false);

        textView = view.findViewById(R.id.versionApp);
        textOsName = view.findViewById(R.id.osName);
        textVersionName = view.findViewById(R.id.versionName);
        textVersionCode = view.findViewById(R.id.versionCode);
        String message = getArguments().getString(EXTRA_MESSAGE);
        int code1 = getArguments().getInt("code");

        textView.setText("App Info");
        textVersionName.setText(BuildConfig.VERSION_NAME);
        textVersionCode.setText(Build.DEVICE);
        Log.i("device", Build.VERSION.BASE_OS);
        textOsName.setText(Build.VERSION.BASE_OS);

        return view;
    }

    public static final ApplicationVersionFragment newInstance(String message) {
        ApplicationVersionFragment f = new ApplicationVersionFragment();
        Bundle args = new Bundle();
        osName = Build.VERSION.BASE_OS;
        device = Build.DEVICE;
        versionName = BuildConfig.VERSION_NAME;
        code = BuildConfig.VERSION_CODE;
        args.putString("os", osName);
        args.putString("device", device);
        args.putInt("code", code);
        args.putString(EXTRA_MESSAGE, message);
        args.putString("name", versionName);
        f.setArguments(args);
        return f;
    }


}

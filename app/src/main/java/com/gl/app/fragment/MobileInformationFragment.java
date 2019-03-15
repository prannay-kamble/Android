package com.gl.app.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gl.app.R;


public class MobileInformationFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "Mobile";
    TextView textView;
    TextView ModelTextView;
    TextView TypetextView;
    TextView hardwareTextView;

    static String hardware, model, id, brand, type, user;

    public MobileInformationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mobile_information, container, false);
        textView = view.findViewById(R.id.mobileFragment);
        ModelTextView = view.findViewById(R.id.modelId);



       // String message = getArguments().getString( Build.BRAND);
        //textView.setText( Build.BRAND);
        ModelTextView.setText("SERIAL: " + Build.SERIAL + "\n" +
        "MODEL: " + Build.MODEL + "\n" +
                "ID: " + Build.ID + "\n" +
                "Manufacture: " + Build.MANUFACTURER + "\n" +
                "Brand: " + Build.BRAND + "\n" +
                "Type: " + Build.TYPE + "\n" +
                "User: " + Build.USER + "\n" +
                "BASE: " + Build.VERSION_CODES.BASE + "\n" +
                "INCREMENTAL: " + Build.VERSION.INCREMENTAL + "\n" +
                "SDK: " + Build.VERSION.SDK + "\n" +
                "BOARD: " + Build.BOARD + "\n" +
                "BRAND: " + Build.BRAND + "\n" +
                "HOST: " + Build.HOST + "\n" +
                "FINGERPRINT: "+Build.FINGERPRINT + "\n" +
                "Version Code: " + Build.VERSION.RELEASE);
       /* TypetextView.setText(Build.TYPE);
        hardwareTextView.setText(Build.HARDWARE);*/
        return view;
    }

    public static final MobileInformationFragment newInstance(String message) {
        MobileInformationFragment f = new MobileInformationFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_MESSAGE, message);
      //  args.putString(brand,);
        //args.putString(hardware, );

        f.setArguments(args);
        return f;
    }


}

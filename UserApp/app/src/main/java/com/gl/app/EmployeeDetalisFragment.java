package com.gl.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;


public class EmployeeDetalisFragment extends Fragment {
    TextView NameText;
    TextView DesgnationText;
    ImageView employeeImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // int n=  getArguments().getInt("image");


        View view = inflater.inflate(R.layout.fragment_employee_detalis, container, false);
        NameText = (TextView) view.findViewById(R.id.employeeName);
        DesgnationText = (TextView) view.findViewById(R.id.employeeDesgnation);
        employeeImage = (ImageView) view.findViewById(R.id.Employeeimage);
        Bundle bundle = getArguments();
        NameText.setText(String.valueOf(bundle.getString("name")));
        DesgnationText.setText(String.valueOf(bundle.getString("desgnation")));
        employeeImage.setImageResource(bundle.getInt("image"));


        return view;
    }
    public boolean onBackPressed() {
        return false;
    }

}




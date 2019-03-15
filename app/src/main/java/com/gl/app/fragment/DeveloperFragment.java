package com.gl.app.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gl.app.R;
import com.gl.app.application.CustomApplication;
import com.gl.app.model.Student;

import java.util.List;


public class DeveloperFragment extends Fragment {


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        CustomApplication application = (CustomApplication) getActivity().getApplication();
        List<Student> students = application.getAllStudent();

        students.forEach(student -> {
            Log.i("Name", student.getName());
        });
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_developer, container, false);
    }


}

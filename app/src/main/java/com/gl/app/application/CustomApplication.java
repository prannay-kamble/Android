package com.gl.app.application;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.util.Log;

import com.gl.app.model.Student;

import java.util.ArrayList;
import java.util.List;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        List<Student> students = new ArrayList<>();
        students.add(new Student("pranay", "Kamble", "Nagpur", "B.E"));

        students.add(new Student("pratik", "Mintra", "Nagpur", "B.E"));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i("onConfiguration Changed", "onConfigurationChanged method");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        Log.i("onLowMemory", "on Low Memory method");
        super.onLowMemory();
    }

    /*
     * List of student data are store
     * **/
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("pranay", "Kamble", "Nagpur", "B.E");
        Student student2 = new Student("pratik", "Mintra", "Nagpur", "B.E");
        students.add(student1);
        students.add(student2);
        return students;
    }


}

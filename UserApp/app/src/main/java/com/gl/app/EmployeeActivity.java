package com.gl.app;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


public class EmployeeActivity extends AppCompatActivity {
    int[] img = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.employeeList, new EmployeeListFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
       if(getSupportFragmentManager().getBackStackEntryCount() == 1){
           finish();
       }else {
           super.onBackPressed();
       }
    }
}


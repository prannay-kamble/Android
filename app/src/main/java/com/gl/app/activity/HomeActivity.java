package com.gl.app.activity;

import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.gl.app.R;
import com.gl.app.application.CustomApplication;
import com.gl.app.fragment.SettingsFragment;
import com.gl.app.fragment.DeveloperFragment;
import com.gl.app.fragment.OrganisationFragment;
import com.gl.app.model.Student;

import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    CustomApplication customApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        CustomApplication customApplication = (CustomApplication) getApplication();
        List<Student> students = customApplication.getAllStudent();

        for (Student student : students) {

            Log.i("Name", student.getName());
            Log.i("SurName", student.getSurname());
            Log.i("city", student.getCity());
            Log.i("Education", student.getEducation());
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            showExitDialog();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * To notify exit from application
     */
    private void showExitDialog() {
        // todo show dialog here with pos+ and -nag button
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomeActivity.this);

        //setting dilag title
        alertDialog.setTitle("alert dialog");

        //setting dialog message
        alertDialog.setMessage("Do You want exit or not");

        //setting icon to dialog
        alertDialog.setIcon(R.drawable.ic_launcher_background);


        //setting ok button
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });

        //setting cancle button to cancel the dialog
        alertDialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (id) {
            case R.id.developerIcon:
                transaction.replace(R.id.fragment_contaner, new DeveloperFragment());
                transaction.commit();
                transaction.addToBackStack(null);
                break;
            case R.id.orgnisation:
                transaction.replace(R.id.fragment_contaner, new OrganisationFragment());
                transaction.commit();
                transaction.addToBackStack(null);
                break;

            case R.id.setting:
                transaction.replace(R.id.fragment_contaner, new SettingsFragment());
                transaction.commit();
                transaction.addToBackStack(null);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onDestroy() {
        List<Student> students = customApplication.getAllStudent();
        students.clear();

        super.onDestroy();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        switch (level) {
            case ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN:
                //relase ul componed
                Log.i("ul memeory", "Relase ui omponed");
                break;
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE:
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW:
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL:
                break;

            case ComponentCallbacks2.TRIM_MEMORY_BACKGROUND:
            case ComponentCallbacks2.TRIM_MEMORY_MODERATE:
            case ComponentCallbacks2.TRIM_MEMORY_COMPLETE:
                break;

            default:
                break;

        }

    }

}

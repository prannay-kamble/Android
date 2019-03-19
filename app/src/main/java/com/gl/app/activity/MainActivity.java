package com.gl.app.activity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.gl.app.R;
import com.gl.app.adapter.CustomFragmentCollectionAdapter;
import com.gl.app.fragment.BasicCalculaterFragment;
import com.gl.app.fragment.ScientificCalculaterFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private CustomFragmentCollectionAdapter customFragmentCollectionAdapter;
    private TabLayout tabLayout;
    private ImageButton red_button;
    private ImageButton blue_button;
    private ImageButton green_button;
    private Toolbar toolbar = null;
    private NavigationView navigationView = null;
    private DrawerLayout drawer = null;
    private RelativeLayout basic_relativeLayout;

    private RelativeLayout scientific_relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        inilizeValue();


        // red_button= viewPager.findViewById(R.id.btn_red);
        red_button = findViewById(R.id.btn_red);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        customFragmentCollectionAdapter = new CustomFragmentCollectionAdapter(getSupportFragmentManager(), getAllFragment());
        viewPager.setAdapter(customFragmentCollectionAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Basic"));
        tabLayout.addTab(tabLayout.newTab().setText("Scintific"));
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // actions
        changeRedColorOnClick();
        changeGreenColorOnClick();
        changeBlueColorOnClick();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //todo changer
        int id = item.getItemId();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (id) {
            case R.id.basic_calculater_id:
                viewPager.setCurrentItem(0);
                break;
            case R.id.scientific_calculater_id:
                viewPager.setCurrentItem(1);

        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private List<Fragment> getAllFragment() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(BasicCalculaterFragment.newInstance("Basic"));
        fragmentList.add(ScientificCalculaterFragment.newInstance("Scientific"));
        return fragmentList;
    }

    /*inilization view component*/

    private void inilizeValue() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
       /* red_button = (ImageButton) navigationView.findViewById(R.id.btn_red);
        blue_button = (ImageButton) navigationView.findViewById(R.id.btn_blue);
        green_button = (ImageButton) navigationView.findViewById(R.id.btn_green);
*/
        red_button = findViewById(R.id.btn_red);
        green_button = findViewById(R.id.btn_green);
        blue_button = findViewById(R.id.btn_blue);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewPager);

    }


    public void changeRedColorOnClick() {
        red_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basic_relativeLayout = findViewById(R.id.basic_relative_id);
                scientific_relativeLayout = findViewById(R.id.scientifc_relative_id);
                basic_relativeLayout.setBackgroundColor(Color.RED);
                scientific_relativeLayout.setBackgroundColor(Color.RED);
                Toast.makeText(MainActivity.this, "RED", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void changeGreenColorOnClick() {

        green_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basic_relativeLayout = findViewById(R.id.basic_relative_id);
                scientific_relativeLayout = findViewById(R.id.scientifc_relative_id);
                basic_relativeLayout.setBackgroundColor(Color.GREEN);
                scientific_relativeLayout.setBackgroundColor(Color.GREEN);
                Toast.makeText(MainActivity.this, "RED", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void changeBlueColorOnClick() {

        blue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basic_relativeLayout = findViewById(R.id.basic_relative_id);
                scientific_relativeLayout = findViewById(R.id.scientifc_relative_id);
                basic_relativeLayout.setBackgroundColor(Color.BLUE);
                scientific_relativeLayout.setBackgroundColor(Color.BLUE);
                Toast.makeText(MainActivity.this, "RED", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * To notify exit from application
     */
    private void showExitDialog() {
        // todo show dialog here with pos+ and -nag button
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

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


}

package com.gl.app.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gl.app.R;
import com.gl.app.adapter.CustomFragmentCollectionAdapter;
import com.gl.app.fragment.ApplicationInfoFragment;
import com.gl.app.fragment.ApplicationVersionFragment;
import com.gl.app.fragment.MobileInformationFragment;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private CustomFragmentCollectionAdapter customFragmentCollectionAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);
        customFragmentCollectionAdapter = new CustomFragmentCollectionAdapter(getSupportFragmentManager(), getAllFragment());

        viewPager.setAdapter(customFragmentCollectionAdapter);
        Toast.makeText(getApplicationContext(), "About Acivity", Toast.LENGTH_SHORT).show();
    }

    private List<Fragment> getAllFragment() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(ApplicationInfoFragment.newInstance("ApplicationFragment"));
        fragmentList.add(MobileInformationFragment.newInstance("MobileFragment"));
        fragmentList.add(ApplicationVersionFragment.newInstance("MobileInformationFragment"));

        return fragmentList;
    }
}

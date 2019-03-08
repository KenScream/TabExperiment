package com.example.tabexperiment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Code inside onCreate() method
        Toolbar toolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create an instance of the tab layout from the view
        TabLayout tablayout = findViewById(R.id.tab_layout);
        // Set the text for each tab.
        tablayout.addTab(tablayout.newTab().setText(R.string.tab_label1));
        tablayout.addTab(tablayout.newTab().setText(R.string.tab_label2));
        tablayout.addTab(tablayout.newTab().setText(R.string.tab_label3));
        // Set the tabs to fill the entire layout.
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapater =new PagerAdapter
                (getSupportFragmentManager(), tablayout.getTabCount());
        viewPager.setAdapter(adapater);
        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
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
    }
}

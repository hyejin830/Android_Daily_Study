package com.example.lesson_6_0325.example02_tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.lesson_6_0325.R;

public class FourImageTabHostActivity extends TabActivity {

    TabHost tabHost;
    TabHost.TabSpec tabSpecMovie1;
    TabHost.TabSpec tabSpecMovie2;
    TabHost.TabSpec tabSpecMovie3;
    TabHost.TabSpec tabSpecMovie4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_image_tab_host);

        tabHost = getTabHost();

        tabSpecMovie1 = tabHost.newTabSpec("MOVIE1").setIndicator("영화1");
        tabSpecMovie1.setContent(R.id.iv_movie_1);
        tabHost.addTab(tabSpecMovie1);

        tabSpecMovie2 = tabHost.newTabSpec("MOVIE2")
                .setIndicator("영화2");
        tabSpecMovie2.setContent(R.id.iv_movie_2);
        tabHost.addTab(tabSpecMovie2);

        tabSpecMovie3 = tabHost.newTabSpec("MOVIE3").setIndicator("영화3");
        tabSpecMovie3.setContent(R.id.iv_movie_3);
        tabHost.addTab(tabSpecMovie3);

        tabSpecMovie4 = tabHost.newTabSpec("MOVIE4").setIndicator("영화4");
        tabSpecMovie4.setContent(R.id.iv_movie_4);
        tabHost.addTab(tabSpecMovie4);

        tabHost.setCurrentTab(0);

    }
}

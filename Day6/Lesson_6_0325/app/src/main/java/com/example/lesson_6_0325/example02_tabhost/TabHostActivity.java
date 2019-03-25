package com.example.lesson_6_0325.example02_tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.lesson_6_0325.R;

public class TabHostActivity extends TabActivity {

    TabHost tabHost;
    TabHost.TabSpec tabSpecSong;
    TabHost.TabSpec tabSpecArtist;
    TabHost.TabSpec tabSpecAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);

        tabHost = getTabHost();

        tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tab_song);
        tabHost.addTab(tabSpecSong);

        tabSpecArtist = tabHost.newTabSpec("ARTIST")
                .setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tab_artist);
        tabHost.addTab(tabSpecArtist);

        tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tab_album);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);

    }
}

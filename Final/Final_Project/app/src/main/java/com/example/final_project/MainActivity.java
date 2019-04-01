package com.example.final_project;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.final_project.fragment.FriendTabFragment;
import com.example.final_project.fragment.SettingTabFragment;
import com.example.final_project.fragment.TalkTabFragment;
import com.example.final_project.fragment.PhotoTabFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private LinearLayout ViewFragementLinearLayout;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private Fragment friendFragment;
    private Fragment talkFragment;
    private Fragment photoFragment;
    private Fragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    void initView() {

        ViewFragementLinearLayout = findViewById(R.id.main_content_linear_layout);

        friendFragment = new FriendTabFragment();
        talkFragment = new TalkTabFragment();
        photoFragment = new PhotoTabFragment();
        settingFragment = new SettingTabFragment();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();


        switch (menuItem.getItemId()) {
            case R.id.menu_friend:
                fragmentTransaction.replace(R.id.main_content_linear_layout, friendFragment);
                fragmentTransaction.commit();
                break;
            case R.id.menu_talk:
                fragmentTransaction.replace(R.id.main_content_linear_layout, talkFragment);
                fragmentTransaction.commit();
                break;
            case R.id.menu_photo:
                fragmentTransaction.replace(R.id.main_content_linear_layout, photoFragment);
                fragmentTransaction.commit();
                break;
            case R.id.menu_setting:
                fragmentTransaction.replace(R.id.main_content_linear_layout, settingFragment);
                fragmentTransaction.commit();
                break;
        }

        return true;
    }
}

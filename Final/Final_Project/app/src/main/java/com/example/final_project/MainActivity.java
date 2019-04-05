package com.example.final_project;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.final_project.db.DBHelper;
import com.example.final_project.fragment.FriendTabFragment;
import com.example.final_project.fragment.PhotoTabFragment;
import com.example.final_project.fragment.SettingTabFragment;
import com.example.final_project.fragment.TalkTabFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private LinearLayout ViewFragementLinearLayout;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private DBHelper dbHelper;
    private SQLiteDatabase sqlDB;

    private Fragment friendFragment;
    private Fragment talkFragment;
    private Fragment photoFragment;
    private Fragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(getApplicationContext());

        if (checkTable(sqlDB, getString(R.string.friend_table_name))) {
            sqlDB = dbHelper.getWritableDatabase();
            dbHelper.onUpgrade(sqlDB, 1, 2);
            sqlDB.close();
        }

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

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, friendFragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();


        switch (menuItem.getItemId()) {
            case R.id.menu_friend:
                friendFragment = new FriendTabFragment();
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

    private boolean checkTable(SQLiteDatabase db, String tableName) {

        try {
            db.rawQuery("SELECT * FROM " + tableName + " limit 1;", null);
        } catch (SQLiteException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

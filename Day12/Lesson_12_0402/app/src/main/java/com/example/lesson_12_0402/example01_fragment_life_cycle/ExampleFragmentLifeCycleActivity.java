package com.example.lesson_12_0402.example01_fragment_life_cycle;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.lesson_12_0402.R;

public class ExampleFragmentLifeCycleActivity extends AppCompatActivity implements View.OnClickListener {

    private static String ActivityName="";

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Button doChangeFragmentButton;
    private int currentFragmentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_fragment_life_cycle);

        initView();

        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_create), Toast.LENGTH_SHORT).show();
    }

    void initView() {

        ActivityName = getString(R.string.fragment_life_cycle__activity);

        doChangeFragmentButton = findViewById(R.id.btn_do_change_fragment);
        doChangeFragmentButton.setOnClickListener(this);
        currentFragmentIndex = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_change_fragment:

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment;

                if (currentFragmentIndex == 0) {
                    fragment = new ExampleFirstFragment();
                    currentFragmentIndex++;
                } else {
                    fragment = new ExampleSecondFragment();
                    currentFragmentIndex--;
                }

                fragmentTransaction.replace(R.id.practice_linear_layout, fragment);
                fragmentTransaction.commit();

                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_start), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_resume), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_restart), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_pause), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_stop), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), ActivityName + getString(R.string.on_destroy), Toast.LENGTH_SHORT).show();
    }
}

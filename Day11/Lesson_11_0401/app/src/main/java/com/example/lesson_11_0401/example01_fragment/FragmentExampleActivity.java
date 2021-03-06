package com.example.lesson_11_0401.example01_fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.lesson_11_0401.R;

public class FragmentExampleActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        initView();

    }

    private void initView() {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        // inflating fragment on LinearLayout
        fragmentTransaction.add(R.id.linear_layout_do_commit_fragment, new ExampleThirdFragment());
        fragmentTransaction.commit();
    }

}

package com.example.lesson_11_0401.practice01_fragment;

import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lesson_11_0401.R;
import com.example.lesson_11_0401.example01_fragment.ExampleFirstFragment;
import com.example.lesson_11_0401.example01_fragment.ExampleSecondFragment;

/**
 * 액티비티 세로 화면일 경우 : 프래그먼트와 버튼1개 , 버튼을 누를 때마다 프래그먼트가 바뀌는 액션
 * 액티비티 가로 화면일 경우 : 프래그먼트 2개 보이기
 */

public class FragmentPracticeActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Button doChangeFragmentButton;
    private int currentFragmentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_practice);

        initView();
    }

    void initView() {

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        // 화면의 크기를 가져오기 위한 과정
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getSize(point);

        int width = point.x;
        int height = point.y;

        if (height > width) { // 세로 모드일 경우만
            doChangeFragmentButton = findViewById(R.id.btn_do_change_fragment);
            doChangeFragmentButton.setOnClickListener(this);
            currentFragmentIndex = 0;
        }


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
}

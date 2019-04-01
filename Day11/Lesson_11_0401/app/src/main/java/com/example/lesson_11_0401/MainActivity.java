package com.example.lesson_11_0401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lesson_11_0401.example01_fragment.FragmentExampleActivity;
import com.example.lesson_11_0401.practice01_fragment.FragmentPracticeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button doStartFragmentExampleButton;
    private Button doStartFragmentPracticeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    void initView() {
        doStartFragmentExampleButton = findViewById(R.id.btn_do_start_fragment_example);
        doStartFragmentPracticeButton = findViewById(R.id.btn_do_start_fragment_practice);

        doStartFragmentExampleButton.setOnClickListener(this);
        doStartFragmentPracticeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_start_fragment_example:
                Intent StartFragmentExampleIntent = new Intent(MainActivity.this, FragmentExampleActivity.class);
                startActivity(StartFragmentExampleIntent);
                break;
            case R.id.btn_do_start_fragment_practice:
                Intent StartFragmentPracticeIntent = new Intent(MainActivity.this, FragmentPracticeActivity.class);
                startActivity(StartFragmentPracticeIntent);
                break;
        }
    }
}


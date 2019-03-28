package com.example.lesson_9_0328.practice01_intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_9_0328.R;

public class SecondIntentPracticeActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnBackSecondToStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_intent_practice);

        btnBackSecondToStart = (Button)findViewById(R.id.btn_back_second_to_start);
        btnBackSecondToStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_second_to_start:
                finish();
                break;
        }
    }
}

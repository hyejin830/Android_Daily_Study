package com.example.lesson_9_0328.practice01_intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_9_0328.R;

public class FirstIntentPracticeActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnBackFirstToStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_intent_practice);

        btnBackFirstToStart = (Button)findViewById(R.id.btn_back_first_to_start);
        btnBackFirstToStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_first_to_start:
                finish();
                break;
        }
    }
}

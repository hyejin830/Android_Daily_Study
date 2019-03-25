package com.example.lesson_6_0325.example01_viewflipper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.example.lesson_6_0325.R;

public class SlideShowPracticeActivity extends AppCompatActivity {

    Button btnStart;
    Button btnStop;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show_practice);

        btnStart = (Button) findViewById(R.id.btn_prev);
        btnStop = (Button) findViewById(R.id.btn_next);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewFlipper.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewFlipper.stopFlipping();
            }
        });


    }
}


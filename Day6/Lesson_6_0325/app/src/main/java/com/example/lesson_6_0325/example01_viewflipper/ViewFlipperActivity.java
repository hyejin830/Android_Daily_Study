package com.example.lesson_6_0325.example01_viewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.example.lesson_6_0325.R;

public class ViewFlipperActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPrev;
    Button btnNext;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_filpper);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnNext = (Button) findViewById(R.id.btn_next);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);

        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_prev:
                viewFlipper.showPrevious();
                break;
            case R.id.btn_next:
                viewFlipper.showNext();
                break;
        }
    }
}


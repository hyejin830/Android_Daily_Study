package com.example.lesson_9_0328.example03_intent_pass_on_data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lesson_9_0328.R;

public class NextExplicitIntentActivity extends AppCompatActivity {

    Intent intentReceiveData;
    TextView tvReceiveStringData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_explicit_intent);

        intentReceiveData = getIntent();
        String receiveDataStringExtra = intentReceiveData.getStringExtra("msg");

        tvReceiveStringData = (TextView) findViewById(R.id.tv_receive_data);
        tvReceiveStringData.setText(receiveDataStringExtra);
    }
}

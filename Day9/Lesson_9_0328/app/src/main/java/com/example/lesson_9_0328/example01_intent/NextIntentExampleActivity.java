package com.example.lesson_9_0328.example01_intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_9_0328.R;

public class NextIntentExampleActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnBackActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_intent_example);

        btnBackActivity = (Button)findViewById(R.id.btn_back);
        btnBackActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                finish();
                break;
        }
    }
}

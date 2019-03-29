package com.example.lesson_10_0329;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_10_0329.example01_implicit_intent.ImplicitIntentExampleActivity;
import com.example.lesson_10_0329.example02_api_use.ApiUseExampleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnImplicitIntentExample;
    Button btnApiUseExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImplicitIntentExample = (Button) findViewById(R.id.btn_implicit_intent_example);
        btnApiUseExample = (Button) findViewById(R.id.btn_api_use_example);

        btnImplicitIntentExample.setOnClickListener(this);
        btnApiUseExample.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_implicit_intent_example:
                Intent intentImplicitIntentExample = new Intent(MainActivity.this, ImplicitIntentExampleActivity.class);
                startActivity(intentImplicitIntentExample);
                break;
            case R.id.btn_api_use_example:
                Intent intentApiUseExample = new Intent(MainActivity.this, ApiUseExampleActivity.class);
                startActivity(intentApiUseExample);
                break;
        }
    }
}


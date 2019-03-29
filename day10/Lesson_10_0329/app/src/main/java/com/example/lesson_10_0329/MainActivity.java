package com.example.lesson_10_0329;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_10_0329.example01_implicit_intent.ImplicitIntentExampleActivity;
import com.example.lesson_10_0329.example02_api_use.ApiUseExampleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnImplicitIntentExample;
    Button btnApiUseExample;
    Button btnExample3;
    Button btnExample4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImplicitIntentExample = (Button)findViewById(R.id.btn_implicit_intent_example);
        btnApiUseExample = (Button)findViewById(R.id.btn_api_use_example);
        btnExample3 = (Button)findViewById(R.id.example3);
        btnExample4 = (Button)findViewById(R.id.example4);

        btnImplicitIntentExample.setOnClickListener(this);
        btnApiUseExample.setOnClickListener(this);
        btnExample3.setOnClickListener(this);
        btnExample4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_implicit_intent_example:
                Intent intentImplicitIntentExample = new Intent(MainActivity.this, ImplicitIntentExampleActivity.class);
                startActivity(intentImplicitIntentExample);
                break;
            case R.id.btn_api_use_example:
                Intent intentApiUseExample = new Intent(MainActivity.this, ApiUseExampleActivity.class);
                startActivity(intentApiUseExample);
                break;
            case R.id.example3:
                Intent intent3 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.example4:
                Intent intent4 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent4);
                break;
        }
    }
}


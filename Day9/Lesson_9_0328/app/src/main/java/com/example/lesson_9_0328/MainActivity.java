package com.example.lesson_9_0328;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_9_0328.example01_intent.PrevIntentExampleActivity;
import com.example.lesson_9_0328.example02_lifecycle.LifeCycleExampleActivity;
import com.example.lesson_9_0328.example03_intent_pass_on_data.PrevExplicitIntentActivity;
import com.example.lesson_9_0328.practice01_intent.StartIntentPracticeActivity;
import com.example.lesson_9_0328.practice02_intent_pass_on_data.CalculatorInputAndResultActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnIntentExample;
    Button btnIntentPractice;
    Button btnLifeCycleExample;
    Button btnExplicitIntentExample;
    Button btnPassOnIntentPractice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntentExample = (Button)findViewById(R.id.btn_intent_example);
        btnIntentPractice = (Button)findViewById(R.id.btn_intent_practice);
        btnLifeCycleExample = (Button)findViewById(R.id.btn_lifecycle_example);
        btnExplicitIntentExample = (Button)findViewById(R.id.btn_explicit_intent_example);
        btnPassOnIntentPractice = (Button)findViewById(R.id.btn_pass_on_intent_practice);

        btnIntentExample.setOnClickListener(this);
        btnIntentPractice.setOnClickListener(this);
        btnLifeCycleExample.setOnClickListener(this);
        btnExplicitIntentExample.setOnClickListener(this);
        btnPassOnIntentPractice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_intent_example:
                Intent intentIntentExample = new Intent(MainActivity.this, PrevIntentExampleActivity.class);
                startActivity(intentIntentExample);
                break;
            case R.id.btn_intent_practice:
                Intent intentIntentPractice = new Intent(MainActivity.this, StartIntentPracticeActivity.class);
                startActivity(intentIntentPractice);
                break;
            case R.id.btn_lifecycle_example:
                Intent intentLifeCycleExample = new Intent(MainActivity.this, LifeCycleExampleActivity.class);
                startActivity(intentLifeCycleExample);
                break;
            case R.id.btn_explicit_intent_example:
                Intent intentExplicitIntentExample = new Intent(MainActivity.this, PrevExplicitIntentActivity.class);
                startActivity(intentExplicitIntentExample);
                break;
            case R.id.btn_pass_on_intent_practice:
                Intent intentPassOnIntentPractice = new Intent(MainActivity.this, CalculatorInputAndResultActivity.class);
                startActivity(intentPassOnIntentPractice);
                break;
        }
    }
}

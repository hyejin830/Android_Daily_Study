package com.example.lesson_10_0329;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_10_0329.example01_implicit_intent.ImplicitIntentExampleActivity;
import com.example.lesson_10_0329.example02_api_use.ApiUseExampleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button doStartImplicitIntentExampleButton;
    private Button doStartApiUseExampleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    void initView() {
        doStartImplicitIntentExampleButton = findViewById(R.id.btn_implicit_intent_example);
        doStartApiUseExampleButton = findViewById(R.id.btn_api_use_example);

        doStartImplicitIntentExampleButton.setOnClickListener(this);
        doStartApiUseExampleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_implicit_intent_example:
                Intent ImplicitIntentExampleIntent = new Intent(MainActivity.this, ImplicitIntentExampleActivity.class);
                startActivity(ImplicitIntentExampleIntent);
                break;
            case R.id.btn_api_use_example:
                Intent ApiUseExampleIntent = new Intent(MainActivity.this, ApiUseExampleActivity.class);
                startActivity(ApiUseExampleIntent);
                break;
        }
    }
}


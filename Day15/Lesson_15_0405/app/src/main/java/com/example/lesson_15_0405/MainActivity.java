package com.example.lesson_15_0405;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_15_0405.adapter.AdapterExampleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button doStartFragmentExampleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    void initView() {

        doStartFragmentExampleButton = findViewById(R.id.btn_do_start_adapter_example);
        doStartFragmentExampleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_start_adapter_example:
                Intent StartFragmentExampleIntent = new Intent(MainActivity.this, AdapterExampleActivity.class);
                startActivity(StartFragmentExampleIntent);
                break;
        }
    }
}



package com.example.passivefirebaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.passivefirebaseexample.example01_service.ServiceExampleActivity;
import com.example.passivefirebaseexample.passive_practice01_firebase.FireBasePracticeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startServiceExampleButton;
    private Button startFireBasePracticeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        startServiceExampleButton = findViewById(R.id.btn_do_start_service_example);
        startFireBasePracticeButton = findViewById(R.id.btn_do_start_fire_base_practice);

        startServiceExampleButton.setOnClickListener(this);
        startFireBasePracticeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_start_service_example:
                Intent doStartServiceExampleIntent = new Intent(this, ServiceExampleActivity.class);
                startActivity(doStartServiceExampleIntent);
                break;
            case R.id.btn_do_start_fire_base_practice:
                Intent doStartFireBasePracticeIntent = new Intent(this, FireBasePracticeActivity.class);
                startActivity(doStartFireBasePracticeIntent);
                break;
        }
    }
}

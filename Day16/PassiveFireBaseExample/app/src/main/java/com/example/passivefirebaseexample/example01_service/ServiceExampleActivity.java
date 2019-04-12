package com.example.passivefirebaseexample.example01_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.passivefirebaseexample.R;

public class ServiceExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ServiceExample";

    private Intent musicServiceIntent;
    private Button musicStartButton;
    private Button musicStopButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);

        initView();
    }

    private void initView() {
        musicServiceIntent = new Intent(this, MusicService.class);
        musicStartButton = findViewById(R.id.btn_do_start_music);
        musicStopButton = findViewById(R.id.btn_do_stop_music);

        musicStartButton.setOnClickListener(this);
        musicStopButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_start_music:
                startService(musicServiceIntent);
                android.util.Log.i(TAG + getString(R.string.log_test_text), getString(R.string.start_service_method));
                break;
            case R.id.btn_do_stop_music:
                stopService(musicServiceIntent);
                android.util.Log.i(TAG + getString(R.string.log_test_text), getString(R.string.stop_service_method));
                break;

        }
    }
}

package com.example.lesson_20_0412;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lesson_20_0412.example02_camera.CameraExampleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView batteryStateImageView;
    private TextView batteryTextView;
    private Button doStartCameraExampleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        batteryStateImageView = findViewById(R.id.iv_battery_state);
        batteryTextView = findViewById(R.id.tv_battery_text);
        doStartCameraExampleButton = findViewById(R.id.do_start_camera_example);

        doStartCameraExampleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.do_start_camera_example:
                Intent startCameraExampleIntent = new Intent(this, CameraExampleActivity.class);
                startActivity(startCameraExampleIntent);
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter broadCastApplyIntentFilter = new IntentFilter();
        broadCastApplyIntentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryBrodCastReceiver, broadCastApplyIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(batteryBrodCastReceiver);
    }


    BroadcastReceiver batteryBrodCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String actionState = intent.getAction();

            if (actionState.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int batteryAmount = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                batteryTextView.setText("현재 충천량 : " + batteryAmount + "\n");

                if (batteryAmount >= 90) {
                    batteryStateImageView.setImageResource(R.drawable.battery_100);
                } else if (batteryAmount >= 70) {
                    batteryStateImageView.setImageResource(R.drawable.battery_80);
                } else if (batteryAmount >= 50) {
                    batteryStateImageView.setImageResource(R.drawable.battery_60);
                } else if (batteryAmount >= 10) {
                    batteryStateImageView.setImageResource(R.drawable.battery_20);
                } else {
                    batteryStateImageView.setImageResource(R.drawable.battery_0);
                }

                int batteryPlugState = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
                switch (batteryPlugState) {
                    case 0:
                        batteryTextView.append(getString(R.string.power_connection_fail));
                        break;
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        batteryTextView.append(getString(R.string.power_connection_adapter));
                        break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        batteryTextView.append(getString(R.string.power_connection_usb));
                        break;
                }
            }
        }
    };


}

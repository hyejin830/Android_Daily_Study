package com.example.lesson_17_04009;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lesson_17_04009.example01_notification.NotificationExampleActivity;
import com.example.lesson_17_04009.practice01_notification.NotificationAsyncTaskActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button doStartNotificationExampleButton;
    private Button doStartNotificationAsyncTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    void initView() {
        doStartNotificationExampleButton = findViewById(R.id.do_start_notification_example);
        doStartNotificationAsyncTaskButton = findViewById(R.id.do_start_notification_async_task);

        doStartNotificationExampleButton.setOnClickListener(this);
        doStartNotificationAsyncTaskButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.do_start_notification_example:
                Intent startNotificationExampleIntent = new Intent(MainActivity.this, NotificationExampleActivity.class);
                startActivity(startNotificationExampleIntent);
                break;
            case R.id.do_start_notification_async_task:
                Intent startNotificationAsyncTaskIntent = new Intent(MainActivity.this, NotificationAsyncTaskActivity.class);
                startActivity(startNotificationAsyncTaskIntent);
                break;
        }
    }
}

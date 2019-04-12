package com.example.lesson_17_04009.practice01_notification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lesson_17_04009.R;

import java.util.concurrent.ExecutionException;

public class NotificationAsyncTaskActivity extends AppCompatActivity implements View.OnClickListener {

    private HttpAsyncTask httpAsyncTask;
    private Button doSendNotificationAsyncTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_async_task);

        initView();
    }

    private void initView() {
        doSendNotificationAsyncTaskButton = findViewById(R.id.btn_do_send_notification_async_task);
        doSendNotificationAsyncTaskButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_send_notification_async_task:
                httpAsyncTask = new HttpAsyncTask();
                String result = null;

                try {
                    result = httpAsyncTask.execute(getString(R.string.send_jsp_file_name), "").get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                break;
        }
    }
}

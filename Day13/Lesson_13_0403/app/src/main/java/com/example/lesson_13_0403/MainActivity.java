package com.example.lesson_13_0403;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson_13_0403.example01_async_task.AsyncTaskExampleActivity;
import com.example.lesson_13_0403.example01_async_task.AsyncTaskSImpleActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button doStartAsyncTaskSimple;
    private Button doStartAsyncTaskExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    void initView() {

        doStartAsyncTaskSimple = findViewById(R.id.btn_start_async_task_simple);
        doStartAsyncTaskExample = findViewById(R.id.btn_start_async_task_example);

        doStartAsyncTaskSimple.setOnClickListener(this);
        doStartAsyncTaskExample.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_async_task_simple:
                Intent startAsyncTaskSimpleIntent = new Intent(MainActivity.this, AsyncTaskSImpleActivity.class);
                startActivity(startAsyncTaskSimpleIntent);
                break;
            case R.id.btn_start_async_task_example:
                Intent startAsyncTaskExampleIntent = new Intent(MainActivity.this, AsyncTaskExampleActivity.class);
                startActivity(startAsyncTaskExampleIntent);
                break;
        }
    }


}

package com.example.lesson_13_0403;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lesson_13_0403.example01_async_task.AsyncTaskExampleActivity;
import com.example.lesson_13_0403.example01_async_task.AsyncTaskSimpleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button doStartAsyncTaskSimple;
    private Button doStartAsyncTaskExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        doStartAsyncTaskSimple = findViewById(R.id.btn_start_async_task_simple);
        doStartAsyncTaskExample = findViewById(R.id.btn_start_async_task_example);

        doStartAsyncTaskSimple.setOnClickListener(this);
        doStartAsyncTaskExample.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_async_task_simple:
                Intent startAsyncTaskSimpleIntent = new Intent(this, AsyncTaskSimpleActivity.class);
                startActivity(startAsyncTaskSimpleIntent);
                break;
            case R.id.btn_start_async_task_example:
                Intent startAsyncTaskExampleIntent = new Intent(this, AsyncTaskExampleActivity.class);
                startActivity(startAsyncTaskExampleIntent);
                break;
        }
    }


}

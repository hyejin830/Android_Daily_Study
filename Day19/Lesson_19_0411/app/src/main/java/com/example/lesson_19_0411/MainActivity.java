package com.example.lesson_19_0411;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MainActivity";

    Button doStartSingletonTestActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        EmailSingleton.getInstance().setData(getString(R.string.singleton_test_success));
        Log.d(TAG, EmailSingleton.getInstance().getData());
    }

    private void initView() {
        doStartSingletonTestActivityButton = findViewById(R.id.btn_do_start_singleton_test_activity);
        doStartSingletonTestActivityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_start_singleton_test_activity:
                Intent startSingletonTestActivityIntent = new Intent(this, SingletonTestActivity.class);
                startActivity(startSingletonTestActivityIntent);
                break;
        }
    }
}

package com.example.lesson_19_0411;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SingletonTestActivity extends AppCompatActivity {

    private TextView getSingletonDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton_test);

        initView();
    }

    private void initView() {
        getSingletonDataTextView = findViewById(R.id.tv_do_get_instance_data);
        getSingletonDataTextView.setText(EmailSingleton.getInstance().getData());
    }
}

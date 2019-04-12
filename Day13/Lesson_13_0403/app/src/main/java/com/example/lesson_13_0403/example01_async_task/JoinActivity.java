package com.example.lesson_13_0403.example01_async_task;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lesson_13_0403.R;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText joinEmailEditText;
    private EditText joinIdEditText;
    private EditText joinPwEditText;

    private Button doJoinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        initView();

    }

    private void initView() {
        joinEmailEditText = findViewById(R.id.et_join_email);
        joinIdEditText = findViewById(R.id.et_join_id);
        joinPwEditText = findViewById(R.id.et_join_pw);
        doJoinButton = findViewById(R.id.btn_do_join);

        doJoinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_join:
                break;
        }
    }
}

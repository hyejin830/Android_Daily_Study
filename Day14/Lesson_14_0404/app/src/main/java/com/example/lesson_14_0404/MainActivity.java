package com.example.lesson_14_0404;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lesson_14_0404.practice.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button doStartPracticeLoginJoinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        doStartPracticeLoginJoinButton = findViewById(R.id.do_start_practice_login_join);
        doStartPracticeLoginJoinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.do_start_practice_login_join:
                Intent doStartPracticeLoginJoinIntent = new Intent(this, LoginActivity.class);
                startActivity(doStartPracticeLoginJoinIntent);
                break;
        }
    }
}



package com.example.lesson_18_0410;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lesson_18_0410.example01_message.MessageExampleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button doStartMessageExampleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        doStartMessageExampleButton = findViewById(R.id.btn_do_start_message_example);
        doStartMessageExampleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_start_message_example:
                Intent startMessageExampleIntent = new Intent(this, MessageExampleActivity.class);
                startActivity(startMessageExampleIntent);
                break;
        }
    }
}

package com.example.lesson_9_0328.practice01_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.lesson_9_0328.R;

public class StartIntentPracticeActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rbFirstIntent;
    RadioButton rbSecondIntent;
    Button btMoveIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_intent_practice);

        rbFirstIntent = (RadioButton) findViewById(R.id.rb_intent_first);
        rbSecondIntent = (RadioButton) findViewById(R.id.rb_intent_second);
        btMoveIntent = (Button) findViewById(R.id.btn_move_intent);

        btMoveIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_intent:
                Intent intentMoveSelectCheck;
                if (rbFirstIntent.isChecked()) {
                    intentMoveSelectCheck = new Intent(getApplicationContext(), FirstIntentPracticeActivity.class);
                    startActivity(intentMoveSelectCheck);
                } else if (rbSecondIntent.isChecked()) {
                    intentMoveSelectCheck = new Intent(getApplicationContext(), SecondIntentPracticeActivity.class);
                    startActivity(intentMoveSelectCheck);
                }

                break;
        }
    }
}

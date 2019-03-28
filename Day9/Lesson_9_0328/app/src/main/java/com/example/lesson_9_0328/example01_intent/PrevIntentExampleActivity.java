package com.example.lesson_9_0328.example01_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_9_0328.R;

public class PrevIntentExampleActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnPrevIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev_intent_example);

        btnPrevIntent = (Button)findViewById(R.id.btn_prev_intent);
        btnPrevIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_prev_intent:
                Intent intentMoveToNext = new Intent(getApplicationContext(), NextIntentExampleActivity.class);
                startActivity(intentMoveToNext);
                break;
        }
    }
}

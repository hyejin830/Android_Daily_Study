package com.example.lesson_9_0328.example03_intent_pass_on_data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_9_0328.R;
import com.example.lesson_9_0328.example01_intent.NextIntentExampleActivity;

public class PrevExplicitIntentActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnPrevExplicitIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev_expilicit_intent);

        btnPrevExplicitIntent = (Button)findViewById(R.id.btn_prev_explicit_intent);
        btnPrevExplicitIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_prev_explicit_intent:
                Intent intentExplicitMoveToNext = new Intent(getApplicationContext(), NextExplicitIntentActivity.class);
                intentExplicitMoveToNext.putExtra("msg","전달메세지");
                startActivity(intentExplicitMoveToNext);
                break;
        }
    }
}

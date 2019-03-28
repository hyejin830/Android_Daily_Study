package com.example.lesson_9_0328.example02_lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.lesson_9_0328.R;

public class LifeCycleExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_example);
        Log.e("LIFECYCLE", "onCreate 호출");
        Toast.makeText(getApplicationContext(), "onCreate 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LIFECYCLE", "onStart 호출");
        Toast.makeText(getApplicationContext(), "onStart 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LIFECYCLE", "onResume 호출");
        Toast.makeText(getApplicationContext(), "onResume 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LIFECYCLE", "onRestart 호출");
        Toast.makeText(getApplicationContext(), "onRestart 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LIFECYCLE", "onPause 호출");
        Toast.makeText(getApplicationContext(), "onPause 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LIFECYCLE", "onStop 호출");
        Toast.makeText(getApplicationContext(), "onStop 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LIFECYCLE", "onDestroy 호출");
        Toast.makeText(getApplicationContext(), "onDestroy 호출", Toast.LENGTH_SHORT).show();
    }
}

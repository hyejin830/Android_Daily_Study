package com.example.lesson_9_0328.practice02_intent_pass_on_data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lesson_9_0328.R;

public class CalculatorExecuteActivity extends AppCompatActivity implements View.OnClickListener{

    Intent intentReceiveNumbers;
    int calculateResultNumber;
    Button btnBackResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_execute);

        intentReceiveNumbers = getIntent();

        String firstReceiveNumber = intentReceiveNumbers.getStringExtra("FIRST");
        String secondReceiveNumber = intentReceiveNumbers.getStringExtra("SECOND");

        calculateResultNumber = Integer.parseInt(firstReceiveNumber) + Integer.parseInt(secondReceiveNumber);

        btnBackResult = (Button)findViewById(R.id.bt_back_result);
        btnBackResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_back_result:
                Intent intentReturnResult = new Intent(getApplicationContext(),CalculatorInputAndResultActivity.class);
                Log.e("HYEJIN",calculateResultNumber+"");
                intentReturnResult.putExtra("RESULT",calculateResultNumber);
                // 1) startActivity(intentReturnResult);
                setResult(RESULT_OK, intentReturnResult);
                finish();
                break;
        }
    }
}

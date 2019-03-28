package com.example.lesson_9_0328.practice02_intent_pass_on_data;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lesson_9_0328.R;

import javax.xml.transform.Result;

public class CalculatorInputAndResultActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etFirstValue;
    EditText etSecondValue;
    Button btnCalculate;
    TextView tvCalculateResult;
    Intent intentReceiveCalculateResult;
    int ResultNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_input_and_result);

        etFirstValue = (EditText) findViewById(R.id.et_first_value);
        etSecondValue = (EditText) findViewById(R.id.et_second_value);
        btnCalculate = (Button) findViewById(R.id.bt_calculate);
        tvCalculateResult = (TextView) findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        /*
        // startActivity로 할 경우
        intentReceiveCalculateResult = getIntent();
        ResultNumber = intentReceiveCalculateResult.getIntExtra("RESULT", 0);
        Log.e("HYEJIN_onRestart", ResultNumber + "");
        tvCalculateResult.setText(ResultNumber + "");*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            ResultNumber = data.getIntExtra("RESULT", 0);
            Log.e("HYEJIN_onRestart", ResultNumber + "");
            tvCalculateResult.setText(ResultNumber + "");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_calculate:
                String firstNumber = etFirstValue.getText().toString();
                String secondNumber = etSecondValue.getText().toString();

                Intent intentGoCalculatorPage = new Intent(getApplicationContext(), CalculatorExecuteActivity.class);
                intentGoCalculatorPage.putExtra("FIRST", firstNumber);
                intentGoCalculatorPage.putExtra("SECOND", secondNumber);
                startActivityForResult(intentGoCalculatorPage,0);
                //finish();
                break;
        }
    }
}

package com.example.lesson_4_0321;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    String InputNum = "";
    double ResultNum=0.0;
    int OpState = -1; // 0 : + , 1 : - , 2 : * , 3: / ,
    EditText edInput;
    TextView tvResult;
    Button btOne,btTwo,btThree,btFour,btFive,btSix,btSeven, btEight,btNine,btZero;
    Button btClear, btExecute, btPlus, btMinus, btDivide, btMultiple, btDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 숫자 버튼
        btOne = (Button)findViewById(R.id.bt_one);
        btTwo = (Button)findViewById(R.id.bt_two);
        btThree = (Button)findViewById(R.id.bt_three);
        btFour = (Button)findViewById(R.id.bt_four);
        btFive = (Button)findViewById(R.id.bt_five);
        btSix = (Button)findViewById(R.id.bt_six);
        btSeven = (Button)findViewById(R.id.bt_seven);
        btEight = (Button)findViewById(R.id.bt_eight);
        btNine = (Button)findViewById(R.id.bt_nine);
        btZero = (Button)findViewById(R.id.bt_zero);

        // 연산 버튼
        btClear = (Button)findViewById(R.id.bt_clear);
        btExecute = (Button)findViewById(R.id.bt_execute);
        btPlus = (Button)findViewById(R.id.bt_plus);
        btMinus = (Button)findViewById(R.id.bt_minus);
        btDivide = (Button)findViewById(R.id.bt_divide);
        btMultiple = (Button)findViewById(R.id.bt_multiple);
        btDot = (Button)findViewById(R.id.bt_dot);

        // 나머지
        edInput = (EditText) findViewById(R.id.et_input);
        tvResult = (TextView)findViewById(R.id.tv_result);

        View.OnClickListener listener = new View.OnClickListener() {

            String tmp;
            @Override
            public void onClick(View v) {
                switch (v.getId()){

                    case R.id.bt_one :
                        tmp = "1";
                        edInput.setText(InputNum+tmp);
                        InputNum = InputNum + tmp;
                        break;
                    case R.id.bt_two :
                        tmp = "2";
                        edInput.setText(InputNum+tmp);
                        InputNum = InputNum + tmp;
                        break;
                    case R.id.bt_three :
                        tmp = "3";
                        edInput.setText(InputNum+tmp);
                        InputNum = InputNum + tmp;
                        break;
                    case R.id.bt_four :
                        tmp = "4";
                        edInput.setText(InputNum+tmp);
                        InputNum = InputNum + tmp;
                        break;
                    case R.id.bt_five :
                        tmp = "5";
                        edInput.setText(InputNum+tmp);
                        InputNum = InputNum + tmp;
                        break;
                    case R.id.bt_six :
                        tmp = "6";
                        edInput.setText(InputNum+tmp);
                        InputNum = InputNum + tmp;
                        break;
                    case R.id.bt_seven :
                        tmp = "7";
                        edInput.setText(InputNum+tmp);
                        InputNum = InputNum + tmp;
                        break;
                    case R.id.bt_eight :
                        tmp = "8";
                        edInput.setText(InputNum+tmp);
                        InputNum = InputNum + tmp;
                        break;
                    case R.id.bt_nine :
                        tmp = "9";
                        edInput.setText(InputNum+tmp);
                        InputNum = InputNum + tmp;
                        break;
                    case R.id.bt_zero :
                        tmp = "0";
                        edInput.setText(InputNum+tmp);
                        InputNum = InputNum + tmp;
                        break;

                        //연산 버튼 이벤트
                    case R.id.bt_clear:
                        InputNum ="";
                        edInput.setText(InputNum);
                        break;
                    case R.id.bt_plus:
                        tmp = "+";
                        OpState = 0;
                        edInput.setText(InputNum+tmp);
                        ResultNum = Double.parseDouble(InputNum);
                        InputNum ="";
                        break;
                    case R.id.bt_minus:
                        tmp = "-";
                        OpState = 1;
                        edInput.setText(InputNum+tmp);
                        ResultNum = Double.parseDouble(InputNum);
                        InputNum ="";
                        break;
                    case R.id.bt_multiple:
                        tmp = "*";
                        OpState = 2;
                        edInput.setText(InputNum+tmp);
                        ResultNum = Double.parseDouble(InputNum);
                        InputNum ="";
                        break;
                    case R.id.bt_divide:
                        tmp = "/";
                        OpState = 3;
                        edInput.setText(InputNum+tmp);
                        ResultNum = Double.parseDouble(InputNum);
                        InputNum ="";
                        break;
                    case R.id.bt_dot:
                        tmp = ".";
                        edInput.setText(InputNum+tmp);
                        InputNum = InputNum + tmp;
                        break;
                    case R.id.bt_execute:
                        double ResultNum2 = Double.parseDouble(InputNum);
                        if(OpState==0){
                            ResultNum = ResultNum + ResultNum2;
                        }else if(OpState==1){
                            ResultNum = ResultNum - ResultNum2;
                        }else if(OpState==2){
                            ResultNum = ResultNum * ResultNum2;
                        }else if(OpState==3){
                            ResultNum = ResultNum / ResultNum2;
                        }

                        tvResult.setText(String.valueOf(ResultNum));
                        InputNum ="";

                        break;

                }
            }
        };

        btOne.setOnClickListener(listener);
        btTwo.setOnClickListener(listener);
        btThree.setOnClickListener(listener);
        btFour.setOnClickListener(listener);
        btFive.setOnClickListener(listener);
        btSix.setOnClickListener(listener);
        btSeven.setOnClickListener(listener);
        btEight.setOnClickListener(listener);
        btNine.setOnClickListener(listener);
        btZero.setOnClickListener(listener);

        btExecute.setOnClickListener(listener);
        btClear.setOnClickListener(listener);
        btPlus.setOnClickListener(listener);
        btMinus.setOnClickListener(listener);
        btMultiple.setOnClickListener(listener);
        btDivide.setOnClickListener(listener);
        btDot.setOnClickListener(listener);

        edInput.setOnClickListener(listener);




    }
}

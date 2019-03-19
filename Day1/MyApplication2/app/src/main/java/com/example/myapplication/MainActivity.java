package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        Toast.makeText(getApplicationContext(), "버튼1 선택",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button2:
                        Toast.makeText(getApplicationContext(), "버튼2 선택",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button3:
                        Toast.makeText(getApplicationContext(), "버튼3 선택",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        Button btn1 = (Button)findViewById(R.id.button);
        Button btn2= (Button)findViewById(R.id.button2);
        Button btn3= (Button)findViewById(R.id.button3);

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
    }
}

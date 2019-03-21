package com.example.lesson_4_0321;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);

        //첫번째 방법 - 익명 클래스

        btn1.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"버튼1 클릭",Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"버튼2 클릭",Toast.LENGTH_SHORT).show();
            }
        });


        //두번째 방법 -


        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn1:
                        Toast.makeText(getApplicationContext(),"버튼1 클릭",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btn2:
                        Toast.makeText(getApplicationContext(),"버튼2 클릭",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);

        */

    }
}


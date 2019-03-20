package com.example.lesson_3_0320;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editid, editpw;
    Button btn;
    TextView textid, textpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* 첫번째 예제용

        editid = (EditText)findViewById(R.id.et_id);
        editpw = (EditText)findViewById(R.id.et_pw);

        btn = (Button)findViewById(R.id.btn_check);

        textid = (TextView)findViewById(R.id.tv_id);
        textpw = (TextView)findViewById(R.id.tv_pw);

        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_check:
                        String id = editid.getText().toString();
                        String pw = editpw.getText().toString();

                        textid.setText("입력하신 ID는 "+id+"입니다");
                        textpw.setText("입력하신 PW는 "+pw+"입니다");
                        break;
                }
            }
        };

        btn.setOnClickListener(listener);

        */
    }
}

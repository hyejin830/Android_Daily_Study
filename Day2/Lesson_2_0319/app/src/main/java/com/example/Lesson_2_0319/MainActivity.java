package com.example.Lesson_2_0319;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.btn1); // select button
        final TextView tv1 = (TextView)findViewById(R.id.tv1);
        final CheckBox cb1 = (CheckBox)findViewById(R.id.cb1);
        final LinearLayout ll = (LinearLayout)findViewById(R.id.layout1);
        final ImageView iv1 = (ImageView)findViewById(R.id.iv1);

        // three radiobutton
        final RadioButton rb1, rb2, rb3;
        rb1 = (RadioButton)findViewById(R.id.rg_dog);
        rb2 = (RadioButton)findViewById(R.id.rg_cat);
        rb3 = (RadioButton)findViewById(R.id.rg_rabbit);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn1 :
                        iv1.setVisibility(View.VISIBLE);
                        if(rb1.isChecked()) iv1.setImageDrawable(getResources().getDrawable(R.drawable.dog));
                        else if(rb2.isChecked()) iv1.setImageDrawable(getResources().getDrawable(R.drawable.cat));
                        else if(rb3.isChecked()) iv1.setImageDrawable(getResources().getDrawable(R.drawable.rabbit));
                        break;
                    case R.id.cb1:
                        if(cb1.isChecked()) ll.setVisibility(View.VISIBLE);
                        else{
                            ll.setVisibility(View.INVISIBLE);
                            rb1.setChecked(false);
                            rb2.setChecked(false);
                            rb3.setChecked(false);
                            iv1.setVisibility(View.INVISIBLE);
                        }
                        break;
                }

            }
        };

        btn1.setOnClickListener(listener);
        cb1.setOnClickListener(listener);
    }
}

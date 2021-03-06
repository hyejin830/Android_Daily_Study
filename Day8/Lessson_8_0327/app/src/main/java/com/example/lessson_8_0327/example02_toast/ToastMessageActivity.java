package com.example.lessson_8_0327.example02_toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.lessson_8_0327.R;

public class ToastMessageActivity extends AppCompatActivity implements View.OnClickListener{

    Button btToastMessageExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_message);

        btToastMessageExample = (Button)findViewById(R.id.bt_toast_example);
        btToastMessageExample.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_toast_example:
                Toast toast = Toast.makeText(ToastMessageActivity.this,"토스트 메세지입니다", Toast.LENGTH_LONG);

                Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

                int xOffset = (int) (Math.random() * display.getWidth());
                int yOffset = (int) (Math.random() * display.getHeight());

                toast.setGravity(Gravity.TOP|Gravity.LEFT,xOffset,yOffset);

                toast.show();

                break;
        }
    }
}

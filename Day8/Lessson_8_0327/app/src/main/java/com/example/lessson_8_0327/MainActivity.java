package com.example.lessson_8_0327;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lessson_8_0327.example01_dialog.DialogExampleActivity;
import com.example.lessson_8_0327.example02_toast.CustomToastMessageActivity;
import com.example.lessson_8_0327.example02_toast.ToastMessageActivity;
import com.example.lessson_8_0327.example03_resource.ResourceExampleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btInflateDialogExample;
    Button btToastMessageExample;
    Button btCustomToastMessageExample;
    Button btResourceExample;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btInflateDialogExample = (Button) findViewById(R.id.bt_inflate_dialog_example);
        btToastMessageExample = (Button) findViewById(R.id.bt_toast_message_example);
        btCustomToastMessageExample = (Button) findViewById(R.id.bt_custom_toast_message_example);
        btResourceExample = (Button) findViewById(R.id.bt_resource_example);

        btInflateDialogExample.setOnClickListener(this);
        btToastMessageExample.setOnClickListener(this);
        btCustomToastMessageExample.setOnClickListener(this);
        btResourceExample.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_inflate_dialog_example:
                Intent itInflateDialogExample = new Intent(MainActivity.this, DialogExampleActivity.class);
                startActivity(itInflateDialogExample);
                break;
            case R.id.bt_toast_message_example:
                Intent itToastMessageExample = new Intent(MainActivity.this, ToastMessageActivity.class);
                startActivity(itToastMessageExample);
                break;
            case R.id.bt_custom_toast_message_example:
                Intent itCustomToastMessageExample = new Intent(MainActivity.this, CustomToastMessageActivity.class);
                startActivity(itCustomToastMessageExample);
                break;
            case R.id.bt_resource_example:
                Intent itResourceExample = new Intent(MainActivity.this, ResourceExampleActivity.class);
                startActivity(itResourceExample);
                break;
        }
    }
}

package com.example.lesson_7_0326;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_7_0326.example01_menu.ContextMenuExampleActivity;
import com.example.lesson_7_0326.example01_menu.ContextMenuPracticeActivity;
import com.example.lesson_7_0326.example01_menu.OptionMenuExampleActivity;
import com.example.lesson_7_0326.example02_dialog.DialogExampleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button goMenuExample;
    Button goContextMenuExample;
    Button goContextMenuPractice;
    Button goDialogExample;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goMenuExample = (Button)findViewById(R.id.btn_menu_example);
        goContextMenuExample = (Button)findViewById(R.id.btn_context_menu);
        goContextMenuPractice = (Button)findViewById(R.id.btn_context_menu_practice);
        goDialogExample = (Button)findViewById(R.id.btn_dialog_example);

        goMenuExample.setOnClickListener(this);
        goContextMenuExample.setOnClickListener(this);
        goContextMenuPractice.setOnClickListener(this);
        goDialogExample.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_menu_example:
                Intent intentMenuExample = new Intent(MainActivity.this, OptionMenuExampleActivity.class);
                startActivity(intentMenuExample);
                break;
            case R.id.btn_context_menu:
                Intent intentContextMenuExample = new Intent(MainActivity.this, ContextMenuExampleActivity.class);
                startActivity(intentContextMenuExample);
                break;
            case R.id.btn_context_menu_practice:
                Intent intentContextMenuPractice = new Intent(MainActivity.this, ContextMenuPracticeActivity.class);
                startActivity(intentContextMenuPractice);
                break;
            case R.id.btn_dialog_example:
                Intent intentDialogExample = new Intent(MainActivity.this, DialogExampleActivity.class);
                startActivity(intentDialogExample);
                break;
        }
    }
}

package com.example.lesson_7_0326.example02_dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lesson_7_0326.R;

public class DialogExampleActivity extends AppCompatActivity implements View.OnClickListener,DialogInterface.OnClickListener {

    Button btnDialogShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_example);

        btnDialogShow = (Button)findViewById(R.id.btn_dialog);

        btnDialogShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dialog:
                AlertDialog.Builder dialog = new AlertDialog.Builder(DialogExampleActivity.this);
                dialog.setTitle("제목");
                //dialog.setMessage("내용");
                dialog.setIcon(R.mipmap.ic_launcher);

                final String[] beverage = new String[]{"콜라","사이다","커피"};
                dialog.setItems(beverage,this);

                //dialog.setSingleChoiceItems(beverage,0,null);

                dialog.setPositiveButton("확인", this);
                dialog.setNegativeButton("취소",this);

                dialog.show();
                break;
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        switch (which){
            case 0:
                Toast.makeText(DialogExampleActivity.this,"콜라",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(DialogExampleActivity.this,"사이다",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(DialogExampleActivity.this,"커피",Toast.LENGTH_SHORT).show();
                break;
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(DialogExampleActivity.this,"확인을 누르셨어요",Toast.LENGTH_SHORT).show();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(DialogExampleActivity.this,"취소를 누르셨어요",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}

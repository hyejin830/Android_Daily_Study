package com.example.lessson_8_0327.example01_dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lessson_8_0327.R;

public class DialogExampleActivity extends AppCompatActivity implements View.OnClickListener,DialogInterface.OnClickListener{

    View inflateDialogView;
    Button btLogin;

    EditText etUserName;
    EditText etUserEmail;

    EditText etDialogUserName;
    EditText etDialogUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_example);

        //Show basic Dialog
        btLogin = (Button) findViewById(R.id.bt_login);
        etUserName = (EditText) findViewById(R.id.et_name);
        etUserEmail = (EditText) findViewById(R.id.et_email);

        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_login:
                inflateDialogView = (View) View.inflate(DialogExampleActivity.this, R.layout.dialog_example, null);

                // Connecting Resource
                etDialogUserName = (EditText) inflateDialogView.findViewById(R.id.et_username);
                etDialogUserEmail = (EditText) inflateDialogView.findViewById(R.id.et_useremail);

                AlertDialog.Builder dialog = new AlertDialog.Builder(DialogExampleActivity.this);
                dialog.setTitle("사용자 정보 입력");
                dialog.setView(inflateDialogView);
                dialog.setPositiveButton("확인",this);
                dialog.setNegativeButton("취소",this);
                dialog.show();
                break;
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                // Getting each String value of EditText
                String userId = etDialogUserName.getText().toString();
                String userEmail = etDialogUserEmail.getText().toString();

                // when click button
                etUserName.setText(userId);
                etUserEmail.setText(userEmail);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                dialog.cancel();
                break;
        }

    }
}
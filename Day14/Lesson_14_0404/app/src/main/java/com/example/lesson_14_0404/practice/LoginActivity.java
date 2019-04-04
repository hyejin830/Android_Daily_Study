package com.example.lesson_14_0404.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lesson_14_0404.MainActivity;
import com.example.lesson_14_0404.R;

import java.util.concurrent.ExecutionException;

import static com.example.lesson_14_0404.R.id.btn_join;
import static com.example.lesson_14_0404.R.id.btn_login;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private HttpAsyncTask httpLoginAsyncTask;

    private EditText InputIdEditText;
    private EditText InputPwEditText;
    private Button doLoginButton;
    private Button doJoinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    void initView() {
        InputIdEditText = findViewById(R.id.et_login_id);
        InputPwEditText = findViewById(R.id.et_login_pw);
        doLoginButton = findViewById(btn_login);
        doJoinButton = findViewById(btn_join);

        doLoginButton.setOnClickListener(this);
        doJoinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case btn_login:
                httpLoginAsyncTask = new HttpAsyncTask();
                String receiveResultMsg;

                try {
                    receiveResultMsg = httpLoginAsyncTask.
                            execute(getString(R.string.login_jsp_file_name),
                                    getString(R.string.email_command) + "=" + InputIdEditText.getText().toString()
                                            + "&" + getString(R.string.password_command) + "="
                                            + InputPwEditText.getText().toString()).get();

                    if (receiveResultMsg.equals(getString(R.string.login_success_msg))) {
                        Intent doLoginIntent = new Intent(LoginActivity.this, ContetnActivity.class);
                        startActivity(doLoginIntent);
                        finish();
                    }

                    Toast.makeText(getApplicationContext(), receiveResultMsg, Toast.LENGTH_LONG).show();


                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            case btn_join:
                Intent doStartJoinIntent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(doStartJoinIntent);
                break;
        }
    }
}

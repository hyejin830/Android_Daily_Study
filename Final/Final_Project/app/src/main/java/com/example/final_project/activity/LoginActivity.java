package com.example.final_project.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.final_project.MainActivity;
import com.example.final_project.R;
import com.example.final_project.async_task.HttpAsyncTask;
import com.example.final_project.pattern.MyEmailSingleton;

import java.util.concurrent.ExecutionException;

import static com.example.final_project.R.id.btn_join;
import static com.example.final_project.R.id.btn_login;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";

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


    private void initView() {
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

                    String getInputIdEditText = InputIdEditText.getText().toString();
                    String getInputPwEditText = InputPwEditText.getText().toString();

                    receiveResultMsg = httpLoginAsyncTask.
                            execute(getString(R.string.login_jsp_file_name),
                                    getString(R.string.email_command) + "=" + getInputIdEditText
                                            + "&" + getString(R.string.password_command) + "="
                                            + getInputPwEditText).get();

                    if (receiveResultMsg.equals(getString(R.string.login_success_msg))) {

                        MyEmailSingleton.getInstance().setMyEmail(getInputIdEditText);

                        Intent doLoginIntent = new Intent(LoginActivity.this, MainActivity.class);
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

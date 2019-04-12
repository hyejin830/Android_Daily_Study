package com.example.lesson_14_0404.practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lesson_14_0404.R;

import java.util.concurrent.ExecutionException;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {

    private HttpAsyncTask httpJoinAsyncTask;

    private EditText joinEmailEditText;
    private EditText joinIdEditText;
    private EditText joinPwEditText;

    private Button doJoinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        initView();

    }

    private void initView() {
        joinEmailEditText = findViewById(R.id.et_join_email);
        joinIdEditText = findViewById(R.id.et_join_id);
        joinPwEditText = findViewById(R.id.et_join_pw);
        doJoinButton = findViewById(R.id.btn_do_join);

        doJoinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_join:

                if (joinEmailEditText.getText().toString() == null
                        || joinIdEditText.getText().toString() == null
                        || joinPwEditText.getText().toString() == null) {
                    Toast.makeText(getApplicationContext(), getString(R.string.do_request_all_item), Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    SignUpAsyncTask();
                }
                break;
        }
    }

    void SignUpAsyncTask() {
        httpJoinAsyncTask = new HttpAsyncTask();
        String receiveResultMsg;

        try {
            receiveResultMsg =
                    httpJoinAsyncTask
                            .execute(getString(R.string.join_jsp_file_name), getString(R.string.email_command) + "=" + joinEmailEditText.getText().toString()
                                    + "&" + getString(R.string.name_command) + "=" + joinIdEditText.getText().toString()
                                    + "&" + getString(R.string.password_command) + "=" + joinPwEditText.getText().toString()).get();

            Toast.makeText(getApplicationContext(), receiveResultMsg, Toast.LENGTH_LONG).show();
            JoinActivity.this.finish();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.example.lesson_13_0403.example01_async_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lesson_13_0403.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class AsyncTaskExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private HttpLoginAsyncTask httpLoginAsyncTask;

    private EditText InputIdEditText;
    private EditText InputPwEditText;
    private Button LoginButton;
    private TextView ResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_example);

        initView();
    }

    void initView() {
        InputIdEditText = findViewById(R.id.etID);
        InputPwEditText = findViewById(R.id.etPW);
        LoginButton = findViewById(R.id.btn_login);
        ResultTextView = findViewById(R.id.tv_result);

        LoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                httpLoginAsyncTask = new HttpLoginAsyncTask();
                String receiveResultMsg;

                try {
                    receiveResultMsg = httpLoginAsyncTask.execute().get();

                    ResultTextView.setText(receiveResultMsg);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public class HttpLoginAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            String receiveMsg = "";
            URL url = null;

            try {
                url = new URL("http://192.168.0.205:8080/Project0403/test.jsp");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");

                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                connection.setDoOutput(true);
                connection.setDoInput(true);

                // 데이터 보낼 때 outputstream 이용
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
                outputStreamWriter.write("id=" + InputIdEditText.getText().toString() + "&pw=" + InputPwEditText.getText().toString());
                outputStreamWriter.flush();

                String line;

                if (connection.getResponseCode() == connection.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(connection.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }
                    receiveMsg = buffer.toString();

                } else {
                    Log.i("hyejin 통신 결과", connection.getResponseCode() + "에러");
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return receiveMsg;
        }
    }


}

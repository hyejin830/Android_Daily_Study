package com.example.lesson_13_0403.example01_async_task;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.lesson_13_0403.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncTaskSimpleActivity extends AppCompatActivity {

    private static final String TAG = "AsyncTaskSimple";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_simple);

        HttpAsyncTask httpAsyncTask = new HttpAsyncTask();

        httpAsyncTask.execute();
    }

    public class HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            URL url = null;
            String resultMessage = "";
            try {
                url = new URL("http://ip Address:8080/Project0403/test.jsp");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");

                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                connection.setDoOutput(true);
                connection.setDoInput(true);

                // 데이터 보낼 때 outputstream 이용
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
                outputStreamWriter.write("id=test&pw=qwer");
                outputStreamWriter.flush();

                String line;

                if (connection.getResponseCode() == connection.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(connection.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }
                } else {
                    Log.i(TAG, "통신 결과 : " + connection.getResponseCode() + "에러");
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            resultMessage = getString(R.string.async_task_success);

            return resultMessage;
        }
    }
}

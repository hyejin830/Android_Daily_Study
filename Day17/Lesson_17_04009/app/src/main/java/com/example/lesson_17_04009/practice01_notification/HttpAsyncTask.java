package com.example.lesson_17_04009.practice01_notification;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpAsyncTask extends AsyncTask<String, Void, String> {
    /**
     * @param strings strings[0] is jsp file name
     * strings[1] is execute command from activity
     * @return received msg from JSP
     */
    private static String TASK_RESULT_MESSEAGE = "Task result";
    private static String receiveMsg;

    @Override
    public String doInBackground(String... strings) {

        HttpURLConnection connection;
        StringBuffer buffer;
        String sendMsg;
        URL url;

        try {

            url = new URL("http://IP Address:8080/Project0403/" + strings[0] + ".jsp");

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.setDoOutput(true);
            connection.setDoInput(true);

            // 데이터 보낼 때 output Stream 이용
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());

            sendMsg = strings[1];

            outputStreamWriter.write(sendMsg);
            outputStreamWriter.flush();

            String line;

            if (connection.getResponseCode() == connection.HTTP_OK) {
                InputStreamReader tmp = new InputStreamReader(connection.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                buffer = new StringBuffer();

                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                receiveMsg = buffer.toString();

            } else {
                Log.i(TASK_RESULT_MESSEAGE, connection.getResponseCode() + "Error");
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return receiveMsg;
    }
}


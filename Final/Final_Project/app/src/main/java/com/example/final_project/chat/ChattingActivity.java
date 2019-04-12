package com.example.final_project.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.final_project.Model.MessageModel;
import com.example.final_project.R;
import com.example.final_project.async_task.HttpAsyncTask;
import com.example.final_project.db.DBHelper;
import com.example.final_project.pattern.MyEmailSingleton;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ChattingActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ChattingActivity";

    private ArrayList<MessageModel> messageModelArrayList;
    private ChattingRecyclerViewAdapter chattingRecyclerViewAdapter;
    private RecyclerView viewMessageWindowRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private EditText inputMessageEditText;
    private Button sendMessageButton;

    private String myEmail;
    private String toEmail;

    private SQLiteDatabase sqLiteDatabase;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        // 내 이메일 주소와 상대방 이메일 주소를 저장
        myEmail = MyEmailSingleton.getInstance().getMyEmail();

        Intent getToEmailFromFriendFragmentIntent = getIntent();
        toEmail = getToEmailFromFriendFragmentIntent.getExtras().getString(getString(R.string.select_to_email));
        Log.d(TAG, "to email value : " + toEmail);

        // ToDo : 내부 DB 생성 후
        dbHelper = new DBHelper(this);
        messageModelArrayList = new ArrayList<>();
        getChattingList();

        initView();
    }


    private void initView() {
        inputMessageEditText = findViewById(R.id.et_input_message);
        sendMessageButton = findViewById(R.id.btn_send_message);
        viewMessageWindowRecyclerView = findViewById(R.id.recycler_view_message_window);

        sendMessageButton.setOnClickListener(this);

        linearLayoutManager = new LinearLayoutManager(this);
        viewMessageWindowRecyclerView.setLayoutManager(linearLayoutManager);

        chattingRecyclerViewAdapter = new ChattingRecyclerViewAdapter(messageModelArrayList, myEmail);
        viewMessageWindowRecyclerView.setAdapter(chattingRecyclerViewAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewMessageWindowRecyclerView.scrollToPosition(chattingRecyclerViewAdapter.getItemCount() - 1);
            }
        }, 200);
    }


    private void getChattingList() {
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqLiteDatabase.rawQuery(
                "SELECT * FROM messages WHERE fromUser='"
                        + myEmail + "' AND toUser='"
                        + toEmail + "' OR fromUser='"
                        + toEmail + "' AND toUser='"
                        + myEmail + "';", null);

        while (cursor.moveToNext()) {
            MessageModel messageModel = new MessageModel(cursor.getString(0),
                    cursor.getString(2));

            messageModelArrayList.add(messageModel);
        }
        cursor.close();
        sqLiteDatabase.close();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_message:

                // TODO : 내부 DB에 메세지 저장

                sqLiteDatabase = dbHelper.getWritableDatabase();
                sqLiteDatabase.execSQL("INSERT INTO messages VALUES ('"
                        + myEmail + "' , '"
                        + toEmail + "' , '"
                        + inputMessageEditText.getText().toString() + "');");
                sqLiteDatabase.close();


                messageModelArrayList.add(new MessageModel(myEmail,
                        inputMessageEditText.getText().toString()));

                sendMessage(myEmail, toEmail, inputMessageEditText.getText().toString());
                chattingRecyclerViewAdapter.notifyDataSetChanged();

                //viewMessageWindowRecyclerView.scrollToPosition(100);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewMessageWindowRecyclerView.scrollToPosition(chattingRecyclerViewAdapter.getItemCount() - 1);
                    }
                }, 200);

                break;
        }
    }

    private void sendMessage(String fromEmail, String toEmail, String message) {
        HttpAsyncTask httpAsyncTask = new HttpAsyncTask();
        String result = null;

        try {
            result = httpAsyncTask.execute
                    (getString(R.string.send_jsp_file), "fromemail=" + fromEmail + "&toemail=" + toEmail + "&message=" + message).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    private BroadcastReceiver chattingBroadCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };
}

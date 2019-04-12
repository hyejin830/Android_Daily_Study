package com.example.lesson_18_0410.example01_message;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lesson_18_0410.R;

import java.util.ArrayList;

public class MessageExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<MessageModel> messageModelArrayList;
    private MessageRecyclerViewAdapter messageRecyclerViewAdapter;
    private RecyclerView viewMessageWindowRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private EditText inputMessageEditText;
    private Button sendMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_example);

        addArrayListOfMessageModel();

        initView();
    }

    private void initView() {
        inputMessageEditText = findViewById(R.id.et_input_message);
        sendMessageButton = findViewById(R.id.btn_send_message);
        viewMessageWindowRecyclerView = findViewById(R.id.recycler_view_message_window);

        sendMessageButton.setOnClickListener(this);

        linearLayoutManager = new LinearLayoutManager(this);
        viewMessageWindowRecyclerView.setLayoutManager(linearLayoutManager);

        messageRecyclerViewAdapter = new MessageRecyclerViewAdapter(messageModelArrayList, getString(R.string.user_name_1));
        viewMessageWindowRecyclerView.setAdapter(messageRecyclerViewAdapter);
    }

    private void addArrayListOfMessageModel() {
        messageModelArrayList = new ArrayList<>();
        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_1), getString(R.string.user_msg_1)));
        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_1), getString(R.string.user_msg_1)));
        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_1), getString(R.string.user_msg_1)));

        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_2), getString(R.string.user_msg_2)));
        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_2), getString(R.string.user_msg_2)));
        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_2), getString(R.string.user_msg_2)));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_message:
                messageModelArrayList.add(new MessageModel(getString(R.string.user_name_1),
                        inputMessageEditText.getText().toString()));


                messageRecyclerViewAdapter.notifyDataSetChanged();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewMessageWindowRecyclerView.scrollToPosition(messageRecyclerViewAdapter.getItemCount() - 1);
                    }
                }, 200);

                break;
        }
    }

    private void sendMessage(String fromEmail, String toEmail, String message) {
        // 다음에
    }
}

package com.example.lesson_10_0329.example01_implicit_intent;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lesson_10_0329.R;

public class ImplicitIntentExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private Button doMakePhoneCallButton;
    private Button doOpenHomePageButton;
    private Button doOpenGoogleMapButton;
    private Button doSendMessageButton;
    private Button doTakePhotoButton;
    private Button doSearchGoogleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent_example);

        initView();
    }

    private void initView() {
        doMakePhoneCallButton = findViewById(R.id.btn_make_call);
        doOpenHomePageButton = findViewById(R.id.btn_open_homepage);
        doOpenGoogleMapButton = findViewById(R.id.btn_open_google_map);
        doSendMessageButton = findViewById(R.id.btn_send_msg);
        doTakePhotoButton = findViewById(R.id.btn_take_photo);
        doSearchGoogleButton = findViewById(R.id.btn_search_google);

        doMakePhoneCallButton.setOnClickListener(this);
        doOpenHomePageButton.setOnClickListener(this);
        doOpenGoogleMapButton.setOnClickListener(this);
        doSendMessageButton.setOnClickListener(this);
        doTakePhotoButton.setOnClickListener(this);
        doSearchGoogleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_make_call:
                Uri MakeCallUri = Uri.parse(getString(R.string.make_call_uri));
                Intent MakeCallIntent = new Intent(Intent.ACTION_VIEW, MakeCallUri);
                startActivity(MakeCallIntent);
                break;
            case R.id.btn_open_homepage:
                Uri OpenHomePageUri = Uri.parse(getString(R.string.open_home_page_uri));
                Intent OpenHomePageIntent = new Intent(Intent.ACTION_VIEW, OpenHomePageUri);
                startActivity(OpenHomePageIntent);
                break;
            case R.id.btn_open_google_map:
                Uri OpenGoogleMapUri = Uri.parse(getString(R.string.open_google_map_uri));
                Intent OpenGoogleMapIntent = new Intent(Intent.ACTION_VIEW, OpenGoogleMapUri);
                startActivity(OpenGoogleMapIntent);
                break;
            case R.id.btn_send_msg:
                Uri SendMsgUri = Uri.parse((getString(R.string.sms_to) + Uri.encode(getString(R.string.send_uri))));
                Intent SendMsgIntent = new Intent(Intent.ACTION_SENDTO, SendMsgUri);
                SendMsgIntent.putExtra(getString(R.string.sms_body), R.string.sms_body_value);
                startActivity(SendMsgIntent);
                break;
            case R.id.btn_take_photo:
                // 기본적인 방법
                Intent TakePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(TakePhotoIntent);
                break;
            case R.id.btn_search_google:
                Intent SearchGoogleIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                SearchGoogleIntent.putExtra(SearchManager.QUERY, R.string.search_google_value);
                startActivity(SearchGoogleIntent);
                break;
        }
    }
}

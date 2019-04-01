package com.example.lesson_10_0329.example01_implicit_intent;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    void initView() {
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
                Uri MakeCallUri = Uri.parse("tel:010-0000-0000");
                Intent MakeCallIntent = new Intent(Intent.ACTION_VIEW, MakeCallUri);
                startActivity(MakeCallIntent);
                break;
            case R.id.btn_open_homepage:
                Uri OpenHomePageUri = Uri.parse("http://www.naver.com");
                Intent OpenHomePageIntent = new Intent(Intent.ACTION_VIEW, OpenHomePageUri);
                startActivity(OpenHomePageIntent);
                break;
            case R.id.btn_open_google_map:
                //Uri uriOpenGoogleMap = Uri.parse("geo");
                Uri OpenGoogleMapUri = Uri.parse("https://www.google.co.kr/maps/place/37%C2%B034'15.5%22N+126%C2%B059'32.5%22E/@37.5709641,126.9918048,19z/data=!3m1!4b1!4m6!3m5!1s0x0:0x0!7e2!8m2!3d37.570963!4d126.9923521");
                Intent OpenGoogleMapIntent = new Intent(Intent.ACTION_VIEW, OpenGoogleMapUri);
                startActivity(OpenGoogleMapIntent);
                break;
            case R.id.btn_send_msg:
                Uri SendMsgUri = Uri.parse(("smsto:" + Uri.encode("010-1234-5678")));
                Intent SendMsgIntent = new Intent(Intent.ACTION_SENDTO, SendMsgUri);
                SendMsgIntent.putExtra("sms_body", "안녕하세요");
                startActivity(SendMsgIntent);
                break;
            case R.id.btn_take_photo:
                // 기본적인 방법
                Intent TakePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(TakePhotoIntent);
                break;
            case R.id.btn_search_google:
                Intent SearchGoogleIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                SearchGoogleIntent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(SearchGoogleIntent);
                break;
        }
    }
}

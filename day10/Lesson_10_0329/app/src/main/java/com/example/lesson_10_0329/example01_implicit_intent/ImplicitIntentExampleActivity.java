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

    Button btnMakePhoneCall;
    Button btnOpenHomePage;
    Button btnOpenGoogleMap;
    Button btnSendMessage;
    Button btnTakePhoto;
    Button btnSearchGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent_example);

        btnMakePhoneCall = (Button) findViewById(R.id.btn_make_call);
        btnOpenHomePage = (Button) findViewById(R.id.btn_open_homepage);
        btnOpenGoogleMap = (Button) findViewById(R.id.btn_open_google_map);
        btnSendMessage = (Button) findViewById(R.id.btn_send_msg);
        btnTakePhoto = (Button) findViewById(R.id.btn_take_photo);
        btnSearchGoogle = (Button) findViewById(R.id.btn_search_google);

        btnMakePhoneCall.setOnClickListener(this);
        btnOpenHomePage.setOnClickListener(this);
        btnOpenGoogleMap.setOnClickListener(this);
        btnSendMessage.setOnClickListener(this);
        btnTakePhoto.setOnClickListener(this);
        btnSearchGoogle.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_make_call:
                Uri uriMakeCall = Uri.parse("tel:010-0000-0000");
                Intent intentMakeCall = new Intent(Intent.ACTION_VIEW, uriMakeCall);
                startActivity(intentMakeCall);
                break;
            case R.id.btn_open_homepage:
                Uri uriOpenHomePage = Uri.parse("http://www.naver.com");
                Intent intentOpenHomePage = new Intent(Intent.ACTION_VIEW, uriOpenHomePage);
                startActivity(intentOpenHomePage);
                break;
            case R.id.btn_open_google_map:
                //Uri uriOpenGoogleMap = Uri.parse("geo");
                Uri uriOpenGoogleMap = Uri.parse("https://www.google.co.kr/maps/place/37%C2%B034'15.5%22N+126%C2%B059'32.5%22E/@37.5709641,126.9918048,19z/data=!3m1!4b1!4m6!3m5!1s0x0:0x0!7e2!8m2!3d37.570963!4d126.9923521");
                Intent intentOpenGoogleMap = new Intent(Intent.ACTION_VIEW, uriOpenGoogleMap);
                startActivity(intentOpenGoogleMap);
                break;
            case R.id.btn_send_msg:
                Uri uriSendMsg = Uri.parse(("smsto:" + Uri.encode("010-1234-5678")));
                Intent intentSendMsg = new Intent(Intent.ACTION_SENDTO, uriSendMsg);
                intentSendMsg.putExtra("sms_body", "안녕하세요");
                startActivity(intentSendMsg);
                break;
            case R.id.btn_take_photo:
                // 기본적인 방법
                Intent intentTakePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intentTakePhoto);
                break;
            case R.id.btn_search_google:
                Intent intentSearchGoogle = new Intent(Intent.ACTION_WEB_SEARCH);
                intentSearchGoogle.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intentSearchGoogle);
                break;
        }
    }
}

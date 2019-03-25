package com.example.lesson_6_0325;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lesson_6_0325.example01_viewflipper.SlideShowPracticeActivity;
import com.example.lesson_6_0325.example01_viewflipper.ViewFlipperActivity;
import com.example.lesson_6_0325.example02_tabhost.FourImageTabHostActivity;
import com.example.lesson_6_0325.example02_tabhost.TabHostActivity;
import com.example.lesson_6_0325.example03_actionbar.ActionBarActivity;
import com.example.lesson_6_0325.example04_webview.WebViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button goViewFlipper;
    Button goSlideShow;
    Button goTabHost;
    Button goFourImageTab;
    Button goActionBar;
    Button goWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goViewFlipper = (Button)findViewById(R.id.btn_view_flipper);
        goSlideShow = (Button)findViewById(R.id.btn_slide_show);
        goTabHost = (Button)findViewById(R.id.btn_tab_host);
        goFourImageTab = (Button)findViewById(R.id.btn_four_image_tab);
        goActionBar = (Button)findViewById(R.id.btn_action_bar);
        goWebView = (Button)findViewById(R.id.btn_web_view);

        goViewFlipper.setOnClickListener(this);
        goSlideShow.setOnClickListener(this);
        goTabHost.setOnClickListener(this);
        goFourImageTab.setOnClickListener(this);
        goActionBar.setOnClickListener(this);
        goWebView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_view_flipper :
                Intent intentViewFlipper = new Intent(MainActivity.this, ViewFlipperActivity.class);
                startActivity(intentViewFlipper);
                break;
            case R.id.btn_slide_show:
                Intent intentSlideShow = new Intent(MainActivity.this, SlideShowPracticeActivity.class);
                startActivity(intentSlideShow);
                break;
            case R.id.btn_tab_host:
                Intent intentTabHost = new Intent(MainActivity.this, TabHostActivity.class);
                startActivity(intentTabHost);
                break;
            case R.id.btn_four_image_tab:
                Intent intentFourImageTab = new Intent(MainActivity.this, FourImageTabHostActivity.class);
                startActivity(intentFourImageTab);
                break;
            case R.id.btn_action_bar:
                Intent intentActionBar= new Intent(MainActivity.this, ActionBarActivity.class);
                startActivity(intentActionBar);
                break;
            case R.id.btn_web_view:
                Intent intentWebView = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intentWebView);
                break;
        }
    }
}

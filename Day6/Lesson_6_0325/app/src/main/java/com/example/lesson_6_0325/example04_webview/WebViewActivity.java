package com.example.lesson_6_0325.example04_webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.example.lesson_6_0325.R;

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener{

    WebView webView;
    EditText etUrl;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (WebView)findViewById(R.id.webview);
        etUrl = (EditText)findViewById(R.id.et_url);
        btnGo = (Button)findViewById(R.id.bt_go);

        btnGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_go :
                webView.loadUrl(etUrl.getText().toString());
                break;
        }
    }
}

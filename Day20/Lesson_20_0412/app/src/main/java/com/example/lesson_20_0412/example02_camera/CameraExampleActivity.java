package com.example.lesson_20_0412.example02_camera;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lesson_20_0412.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class CameraExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView viewDataTextView;
    private TextView viewAddressTextView;
    private Button doScanButton;
    private IntentIntegrator qrCodeScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_example);

        initView();
    }

    private void initView() {
        viewDataTextView = findViewById(R.id.tv_view_data);
        viewAddressTextView = findViewById(R.id.tv_view_address);
        doScanButton = findViewById(R.id.btn_do_scan);
        doScanButton.setOnClickListener(this);

        qrCodeScan = new IntentIntegrator(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_scan:
                qrCodeScan.setPrompt(getString(R.string.qr_code_scanning));
                qrCodeScan.initiateScan();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(this, getString(R.string.scan_cancel), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.scan_success), Toast.LENGTH_SHORT).show();

                try {
                    JSONObject jsonObject = new JSONObject(intentResult.getContents());
                    viewDataTextView.setText(jsonObject.getString("data"));
                    viewAddressTextView.setText(jsonObject.getString("address"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }

    }
}

package com.example.passivefirebaseexample.passive_practice01_firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.passivefirebaseexample.R;
import com.google.firebase.iid.FirebaseInstanceId;

public class FireBasePracticeActivity extends AppCompatActivity {

    private static final String TAG = "FireBasePractice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_base_practice);

        String token = null;

        token = FirebaseInstanceId.getInstance().getToken();

        if (token != null) {
            Log.d(TAG + "토큰 생성", "token =" + token);
        }
    }
}

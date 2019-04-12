package com.example.passivefirebaseexample.passive_practice01_firebase;

import android.util.Log;

import com.example.passivefirebaseexample.R;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFireBaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "InstanceIdService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG + getString(R.string.token_create), getString(R.string.token_value) + token);
    }
}


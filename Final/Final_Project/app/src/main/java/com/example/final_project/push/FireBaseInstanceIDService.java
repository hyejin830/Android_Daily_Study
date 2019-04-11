package com.example.final_project.push;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FireBaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "InstanceIdService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG + "토큰 생성", "token =" + token);
    }
}


package com.example.passivefirebaseexample.example01_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.passivefirebaseexample.R;

public class MusicService extends Service {

    private static final String TAG = "MusicService";


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        android.util.Log.i(TAG + getString(R.string.log_test_text), getString(R.string.on_create_method));
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        android.util.Log.i(TAG + getString(R.string.log_test_text), getString(R.string.on_start_command_method));
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        android.util.Log.i(TAG + getString(R.string.log_test_text), getString(R.string.on_destroy_method));
        super.onDestroy();
    }
}

package com.example.passivefirebaseexample.passive_practice01_firebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.passivefirebaseexample.MainActivity;
import com.example.passivefirebaseexample.R;
import com.google.firebase.messaging.RemoteMessage;

public class MyFireBaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    private static final String TAG = "MessagingService";

    // 메시지 수신
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();

        Log.d(TAG + getString(R.string.log_title), title);
        Log.d(TAG + getString(R.string.log_cotent), message);

        sendNotification(title, message);
    }


    // 내일 설명
    private void sendNotification(String title, String message) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String name = getString(R.string.notification_text);
        String channel_id = getString(R.string.fcm_default_channel);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(channel_id, name, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(mChannel);
        }


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, channel_id)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_dialog_info))
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);


        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}

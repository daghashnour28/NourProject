package com.example.nourdaghash;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;

public class Receiver extends BroadcastReceiver {
    @
            Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, MyIntentService.class);
        context.startService(service);
    }


    public class MyIntentService extends IntentService {
        private static final String CHANNEL_ID = "CHANNEL_3";
        private static final int REQUEST_CODE = 1;
        private static final int NOTIFICATION_ID = 1;

        /**
         * @deprecated
         */

        public MyIntentService() {
            super("MyService");
        }

        @Override
        protected void onHandleIntent(@Nullable Intent intent) {
            //createNotificationChannel();
            Notification.Builder nBuilder = new Notification.Builder(this);
            nBuilder.setContentTitle("This is Notification Title");
            nBuilder.setContentText("This is the notification body/description");
            nBuilder.setSmallIcon(R.drawable.ic_baseline_local_florist_24); //what to do when the notification is clicked
            Intent intent1 = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, REQUEST_CODE, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
            //connects the pending intent with the notification object,
            // when the user clicks the on the notification the pending intent is called

        }
    }
}
package com.vipin.mvvm_vip_demo.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.vipin.mvvm_vip_demo.R;


/**
 * Created by vipin on 2/3/17.
 */
public class ShowNotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("Reciever", "onCreate-notification");

        showNotification(intent.getExtras(),context);
    }

/*
    private void ShowNotification(Context context) {

        //show a notification builder to the for the user to get to know tracking is happening backgroundly
        Intent notificationIntent = new Intent();
        Bundle b = new Bundle();

        b.putCharSequence("message", "Driver");
        b.putCharSequence("title", "Turn on Internet for tracking");

        notificationIntent.putExtras(b);
        notificationIntent.setAction("ke.co.ShowNotificationReceiver");
        context.sendBroadcast(notificationIntent);

    }*/

    private void showNotification(Bundle data, Context context) {

        /**
         * here displaying that notification
         */
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Bitmap largIcon = BitmapFactory.decodeResource(context.getResources(),
                R.mipmap.ic_launcher_round);


        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService
                (Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel("notification",
                    "CustomNotification", NotificationManager.IMPORTANCE_HIGH);

                    notificationChannel.setShowBadge(true);
                    notificationChannel.canShowBadge();
                    notificationChannel.enableLights(true);
                    notificationChannel.enableVibration(true);
                    notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

                    mNotificationManager.createNotificationChannel(notificationChannel);


            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notification");

                 builder.setLargeIcon(largIcon)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setContentTitle(data.getCharSequence("title"))
                         .setColor(context.getResources().getColor(R.color.colorPrimary))
                        .setAutoCancel(true)
                        .setSound(soundUri)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(data.getCharSequence("message")))
                        .setContentText(data.getCharSequence("message"));

            long[] vibrate = {0, 100, 200, 300};
            builder.setVibrate(vibrate);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder.setSmallIcon(R.drawable.ic_launcher_background);
            } else {
                builder.setSmallIcon(R.drawable.ic_launcher_background);
            }

                Notification notification = builder.build();

                mNotificationManager.notify(1, notification);

            //  DeleteChannel(context); // delete channel after use

        }

        else {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setLargeIcon(largIcon)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentTitle(data.getCharSequence("title"))
                .setAutoCancel(true)
                .setSound(soundUri)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(data.getCharSequence("message")))
                .setContentText(data.getCharSequence("message"));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        } else {
            mBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        }


        long[] vibrate = {0, 100, 200, 300};
        mBuilder.setVibrate(vibrate);

        mNotificationManager.notify(1, mBuilder.build());

    }
    }

    void DeleteChannel(Context context){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

         /*   NotificationChannel notificationChannel =
                    notificationManager.getNotificationChannel("notification");*/

            notificationManager.deleteNotificationChannel("notification");
        }
    }
}

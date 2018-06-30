package com.app.bissudroid.androidtutorials.outputs.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.app.bissudroid.androidtutorials.Constants;
import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.activity.MainActivity;

import timber.log.Timber;

public class NotificationActivity extends AppCompatActivity {
    NotificationManager notificationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button normal = findViewById(R.id.normalnotification);
        Button inbox = findViewById(R.id.inboxstyle);
        Button big = findViewById(R.id.bigstyle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Notifications");
        normal.setOnClickListener(v -> showNormal());
        inbox.setOnClickListener(v -> InboxStyle());
        big.setOnClickListener(v -> BigPictureStyle());


    }


    private NotificationManager getNotificationManager() {
        if (notificationManager == null) {
            notificationManager = (NotificationManager) getApplicationContext().getSystemService(
                    Context.NOTIFICATION_SERVICE);
        }
        return notificationManager;
    }

    private void showNormal() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(Constants.PRIMARY_NOTIFICATION_CHANNEL, "Examples",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setLightColor(Color.GREEN);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            getNotificationManager().createNotificationChannel(channel);
        }
        else {
            notificationManager=getNotificationManager();
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, Constants.PRIMARY_NOTIFICATION_CHANNEL)
                .setSmallIcon(R.drawable.app_icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.app_icon))
                .setContentTitle("New Message")
                .setContentText("Normal Notification")
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setChannelId(Constants.PRIMARY_NOTIFICATION_CHANNEL)
                .setContentIntent(pendingIntent);

        final NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(getApplicationContext());

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

    private void InboxStyle() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1 /* Request code */, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(Constants.SECOND_NOTIFICATION_CHANNEL, "Examples",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setLightColor(Color.GREEN);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            getNotificationManager().createNotificationChannel(channel);
        }
        else {
            notificationManager=getNotificationManager();
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, Constants.SECOND_NOTIFICATION_CHANNEL)
                .setSmallIcon(R.drawable.app_icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.app_icon))
                .setContentTitle("New Message")
                .setContentText("Inbox Style Notification.Expand me")
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.InboxStyle().addLine("Hello").addLine("First Line")
                        .addLine("Second Line").addLine("Three New Messages For you").setSummaryText("Inbox"))
                .setSound(defaultSoundUri)
                .setChannelId(Constants.SECOND_NOTIFICATION_CHANNEL)
                .setContentIntent(pendingIntent);
        if (notificationManager != null) {
            Timber.d("notification shown");
            notificationManager.notify(1 /* ID of notification */, notificationBuilder.build());
        }


    }

    private void BigPictureStyle() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2/* Request code */, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(Constants.THIRD_NOTIFICATION_CHANNEL, "Examples",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setLightColor(Color.GREEN);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            getNotificationManager().createNotificationChannel(channel);
        }
        else {
            notificationManager=getNotificationManager();
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, Constants.THIRD_NOTIFICATION_CHANNEL)
                .setSmallIcon(R.drawable.app_icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.app_icon))
                .setContentTitle("New Message")
                .setContentText("Big Image Notification")
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.header_background))
                        .bigLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.app_icon)).setSummaryText("Big Image notification")
                        .setBigContentTitle("Notification For You"))
                .setSound(defaultSoundUri)
                .setChannelId(Constants.THIRD_NOTIFICATION_CHANNEL)
                .setContentIntent(pendingIntent);
        if (notificationManager != null) {
            notificationManager.notify(2 /* ID of notification */, notificationBuilder.build());
        }
    }
}

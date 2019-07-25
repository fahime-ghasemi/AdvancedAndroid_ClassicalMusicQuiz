package com.example.android.classicalmusicquiz;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.io.File;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.os.Build;


class Utils {

       public static String createNotificationChannel( Context context)
                {

            // NotificationChannels are required for Notifications on O (API 26) and above.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                // The id of the channel.
                String channelId = "espica";

                // The user-visible name of the channel.
                String channelName = "Espica channel";
                // The user-visible description of the channel.
                String channelDescription = "Espica channel desc";
                int channelImportance = NotificationManager.IMPORTANCE_DEFAULT;
                boolean channelEnableVibrate =false;
//                val channelLockscreenVisibility = false

                // Initializes NotificationChannel.
                NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, channelImportance);
                notificationChannel.setDescription(channelDescription);
                notificationChannel.enableVibration(channelEnableVibrate);
//                notificationChannel.lockscreenVisibility = channelLockscreenVisibility

                // Adds NotificationChannel to system. Attempting to create an existing notification
                // channel with its original values performs no operation, so it's safe to perform the
                // below sequence.
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(notificationChannel);

                return channelId;
            } else {
                // Returns null for pre-O (26) devices.
                return "";
            }
        }
    }
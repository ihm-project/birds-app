package com.example.birdsapp.tools;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.birdsapp.R;

public class NotificationTool  extends ContextWrapper {
    private NotificationManager notifManager;

    private static final String CHANNEL_HIGH_ID = "com.infinisoftware.testnotifs.HIGH_CHANNEL";
    private static final String CHANNEL_HIGH_NAME = "High Channel";

    private static final String CHANNEL_DEFAULT_ID = "com.infinisoftware.testnotifs.DEFAULT_CHANNEL";
    private static final String CHANNEL_DEFAUL_NAME = "Default Channel";


    @RequiresApi(api = Build.VERSION_CODES.O)
    public NotificationTool(Context base ) {

        super( base );

        notifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        long [] swPattern = new long[] { 0, 500, 110, 500, 110, 450, 0 };

        NotificationChannel notificationChannelHigh = new NotificationChannel(
                CHANNEL_HIGH_ID, CHANNEL_HIGH_NAME, notifManager.IMPORTANCE_HIGH );
        notificationChannelHigh.enableLights( true );
        notificationChannelHigh.setLightColor( Color.RED );
        notificationChannelHigh.setShowBadge( true );
        notificationChannelHigh.enableVibration( true );
        notificationChannelHigh.setVibrationPattern( swPattern );
        notificationChannelHigh.setLockscreenVisibility( Notification.VISIBILITY_PUBLIC );
        notifManager.createNotificationChannel( notificationChannelHigh );

        NotificationChannel notificationChannelDefault = new NotificationChannel(
                CHANNEL_DEFAULT_ID, CHANNEL_DEFAUL_NAME, notifManager.IMPORTANCE_DEFAULT );
        notificationChannelDefault.enableLights( true );
        notificationChannelDefault.setLightColor( Color.WHITE );
        notificationChannelDefault.enableVibration( true );
        notificationChannelDefault.setShowBadge( false );
        notifManager.createNotificationChannel( notificationChannelDefault );
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notify(int id, boolean prioritary, String title, String message ) {
        String channelId = prioritary ? CHANNEL_HIGH_ID : CHANNEL_DEFAULT_ID;
        Resources res = getApplicationContext().getResources();

        Notification notification = new Notification.Builder( getApplicationContext(), channelId )
                .setContentTitle( title )
                .setContentText( message )
                .setSmallIcon( R.drawable.ic_launcher_foreground )
                .setLargeIcon( BitmapFactory.decodeResource(res, R.drawable.ic_launcher_foreground) )
                .setAutoCancel( true )
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.pigeon))
                .build();

        notifManager.notify( id, notification );
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notify(int id, boolean prioritary, String title, String message, int idImg) {
        notify(id, prioritary, title, message, BitmapFactory.decodeResource(getResources(), idImg));
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notify(int id, boolean prioritary, String title, String message, Bitmap img) {
        String channelId = prioritary ? CHANNEL_HIGH_ID : CHANNEL_DEFAULT_ID;
        Resources res = getApplicationContext().getResources();

        Notification notification = new Notification.Builder( getApplicationContext(), channelId )
                .setContentTitle( title )
                .setContentText( message )
                .setSmallIcon( R.drawable.ic_launcher_foreground )
                .setLargeIcon( BitmapFactory.decodeResource(res, R.drawable.ic_launcher_foreground) )
                .setAutoCancel( true )
                .setLargeIcon(img)
                .build();

        notifManager.notify( id, notification );
    }
}

package com.example.win7.aukcijaproject;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.res.TypedArrayUtils;

/**
 * Created by win7 on 17.5.2017.
 */

public class AuctionBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
     NotificationCompat.Builder mBuilder =   new NotificationCompat.Builder(context)
                .setSmallIcon(android.R.drawable.ic_menu_add)
                .setOnlyAlertOnce(true)
                .setSound(alarmSound)
                .setContentTitle("Auction Aplication")
                .setContentText("Vasa ponuda je najveca!");
        mBuilder.setAutoCancel(true);
       Intent resultIntent = new Intent(context,ItemActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(ItemActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(001,mBuilder.build());

}
}

package com.example.win7.aukcijaproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by win7 on 17.5.2017.
 */

public class AuctionService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AsyncTask as = new AsyncTask();
        as.execute(getApplicationContext());
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

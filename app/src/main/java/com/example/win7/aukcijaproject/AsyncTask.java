package com.example.win7.aukcijaproject;

import android.content.Context;
import android.content.Intent;

/**
 * Created by win7 on 17.5.2017.
 */

public class AsyncTask extends android.os.AsyncTask<Context, String, Context> {

    @Override
    protected void onPostExecute(Context context) {
        super.onPostExecute(context);
        Intent i = new Intent("best_price");
        context.sendBroadcast(i);
    }

    @Override
    protected Context doInBackground(Context... params) {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
                ex.printStackTrace();
        }
        return params[0];
    }
}

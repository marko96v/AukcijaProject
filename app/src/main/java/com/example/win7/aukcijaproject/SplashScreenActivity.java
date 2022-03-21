package com.example.win7.aukcijaproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.table.DatabaseTableConfig;



public class SplashScreenActivity  extends OrmLiteBaseActivity<DatabaseHelper>  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        mokap.userDao = getHelper().getUserDataDao();
        mokap.itemDao = getHelper().getItemDataDao();
        mokap.auctionDao = getHelper().getAuctionDataDao();
        mokap.bidDao = getHelper().getBidDataDao();


        mokap.users = mokap.userDao.queryForAll();
        mokap.items = mokap.itemDao.queryForAll();
        mokap.auctions = mokap.auctionDao.queryForAll();
        mokap.bids = mokap.bidDao.queryForAll();



        Auction a = mokap.getAuctions().get(1);
        Item i = mokap.getItems().get(1);

        User u = mokap.users.get(0);

        Thread nit = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        nit.start();


        // getting preference object
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        boolean displaySplash = prefs.getBoolean("splash_enable_pref", true);
        if(!displaySplash){
            startItemsActivity();
            return;
        }

        String timeoutTmp = prefs.getString("splash_duration_pref", "5");
        final int timeout = Integer.parseInt(timeoutTmp);

        if(timeout < 1){ startItemsActivity(); return;}

       // setContentView(R.layout.activity_splashscreen);
        setContentView(R.layout.activity_splash_screen);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(timeout * 1000);
                    startItemsActivity();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }

            }
        }).start();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {}

    private void startItemsActivity(){
//        Intent intent = new Intent(this, ItemsActivity.class);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

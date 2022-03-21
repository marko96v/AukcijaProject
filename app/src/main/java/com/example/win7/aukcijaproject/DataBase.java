package com.example.win7.aukcijaproject;

import android.content.Intent;
import android.os.Bundle;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;


public class DataBase extends OrmLiteBaseActivity<DatabaseHelper> {

    private final String LOG_TAG = getClass().getSimpleName();
    private final static int MAX_NUM_TO_CREATE = 8;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        RuntimeExceptionDao<Item, Long> itemDao = getHelper().getItemDataDao();
        RuntimeExceptionDao<Auction, Long> auctionDao = getHelper().getAuctionDataDao();
        RuntimeExceptionDao<Bid, Long> bidDao = getHelper().getBidDataDao();
        RuntimeExceptionDao<User, Long> userDao = getHelper().getUserDataDao();

        Intent intent = new Intent(this, SplashScreenActivity.class);
        startActivity(intent);

    }
}

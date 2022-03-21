package com.example.win7.aukcijaproject;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class mokap {


    public static RuntimeExceptionDao<User, Long> userDao;
    public static RuntimeExceptionDao<Item, Long> itemDao;
    public static RuntimeExceptionDao<Auction, Long> auctionDao;
    public static RuntimeExceptionDao<Bid, Long> bidDao;

    public static List<Item> items;
    public static List<Auction> auctions;
    public static List<User> users;
    public static List<Bid> bids;

    public static List<Item> getItems(){
        return items;
    }

    public static   List<Auction> getAuctions() {

        return auctions;
    }

    public static List<Bid> getBids(){
        return bids;
    }

    public static int toMinutes(int minutes){return  1000*60*minutes;}
}

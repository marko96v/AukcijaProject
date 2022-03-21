package com.example.win7.aukcijaproject;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.Date;
/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "aukcija.db";
    private static final int DATABASE_VERSION = 1;

    // the DAO object we use to access the SimpleData table
    private Dao<User,Long> userDao = null;
    private RuntimeExceptionDao<User,Long> userLongRuntimeExceptionDao = null;
    private Dao<Item,Long> itemDao = null;
    private RuntimeExceptionDao<Item,Long> itemLongRuntimeExceptionDao = null;
    private Dao<Bid,Long> bidDao = null;
    private RuntimeExceptionDao<Bid,Long> bidLongRuntimeExceptionDao = null;
    private Dao<Auction,Long> auctionDao = null;
    private RuntimeExceptionDao<Auction,Long> auctionLongRuntimeExceptionDao = null;



    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION,R.raw.ormlite_config);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource){
        try{
            TableUtils.createTable(connectionSource, Auction.class);
            TableUtils.createTable(connectionSource, Bid.class);
            TableUtils.createTable(connectionSource, Item.class);
            TableUtils.createTable(connectionSource, User.class);

            // here we try inserting data in the on-create as a test
            RuntimeExceptionDao<Item, Long> daoItem = getItemDataDao();
            RuntimeExceptionDao<User, Long> daoUser = getUserDataDao();
            RuntimeExceptionDao<Auction, Long> daoAuction = getAuctionDataDao();
            RuntimeExceptionDao<Bid, Long> daoBid = getBidDataDao();


            User u = new User("Ime","EMAIL");
            daoUser.create(u);

            Item i = new Item("ITEM IME","ITEM OPIS","ic_launcher");
            daoItem.create(i);

            Item i1 = new Item("item ime2","item opis2","ic_launcher");
            daoItem.create(i1);

            Auction a = new Auction(1,new Date(),new Date(),u);
            a.setItem(i1);
            a.setUser(u);
            daoAuction.create(a);

            Auction a1 = new Auction(2,new Date(),new Date(),u);
            a1.setItem(i1);
            a1.setUser(u);
            daoAuction.create(a1);

            Bid b = new Bid(2,a1,u);
            daoBid.create(b);

            Bid b1 = new Bid(3,a1,u);
            daoBid.create(b1);


        }catch (SQLException e){
            Log.e(DatabaseHelper.class.getName(),"Cant create database",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion){
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Auction.class,true);
            TableUtils.dropTable(connectionSource, Bid.class,true);
            TableUtils.dropTable(connectionSource, Item.class,true);
            TableUtils.dropTable(connectionSource, User.class,true);

            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }


    public Dao<Item, Long> getItemDao() throws SQLException {
        if (itemDao == null) {
            itemDao = getDao(Item.class);
        }
        return itemDao;
    }
    public Dao<User, Long> getUserDao() throws SQLException {
        if (userDao == null) {
            userDao = getDao(User.class);
        }
        return userDao;
    }
    public Dao<Auction, Long> getAuctionDao() throws SQLException {
        if (auctionDao == null) {
            auctionDao = getDao(Auction.class);
        }
        return auctionDao;
    }
    public Dao<Bid, Long> getBidDao() throws SQLException {
        if (bidDao == null) {
            bidDao = getDao(Bid.class);
        }
        return bidDao;
    }

    public RuntimeExceptionDao<Item, Long> getItemDataDao() {
        if (itemLongRuntimeExceptionDao == null) {
            itemLongRuntimeExceptionDao = getRuntimeExceptionDao(Item.class);
        }
        return itemLongRuntimeExceptionDao;
    }
    public RuntimeExceptionDao<Auction, Long> getAuctionDataDao() {
        if (auctionLongRuntimeExceptionDao == null) {
            auctionLongRuntimeExceptionDao = getRuntimeExceptionDao(Auction.class);
        }
        return auctionLongRuntimeExceptionDao;
    }
    public RuntimeExceptionDao<User, Long> getUserDataDao() {
        if (userLongRuntimeExceptionDao == null) {
            userLongRuntimeExceptionDao = getRuntimeExceptionDao(User.class);
        }
        return userLongRuntimeExceptionDao;
    }
    public RuntimeExceptionDao<Bid, Long> getBidDataDao() {
        if (bidLongRuntimeExceptionDao == null) {
            bidLongRuntimeExceptionDao = getRuntimeExceptionDao(Bid.class);
        }
        return bidLongRuntimeExceptionDao;
    }

    @Override
    public void close() {
        super.close();
        itemLongRuntimeExceptionDao=null;
        itemDao=null;
        auctionDao=null;
        auctionLongRuntimeExceptionDao=null;
        userDao=null;
        userLongRuntimeExceptionDao=null;
        bidDao=null;
        bidLongRuntimeExceptionDao=null;
    }

}

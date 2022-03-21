package com.example.win7.aukcijaproject;


import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


@DatabaseTable(tableName = "bids")
public class Bid {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    public double price;
    @DatabaseField
    public Date dateTime;
    @DatabaseField(canBeNull = false,foreign = true,foreignAutoRefresh = true)
    public Auction auction;
    @DatabaseField(canBeNull = false,foreign = true,foreignAutoRefresh = true)
    public User user;

    public Bid(){

    }

    public Bid(double Price,Auction auction,User user){
        this.price = price;
        this.auction = auction;
        this.user = user;
        this.dateTime = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", price=" + price +
                ", dateTime=" + dateTime +
                ", auction=" + auction +
                ", user=" + user +
                '}';
    }
}

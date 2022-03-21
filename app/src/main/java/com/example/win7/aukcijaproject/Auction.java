package com.example.win7.aukcijaproject;


import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DatabaseTable(tableName = "auctions")
public class Auction implements Serializable {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    public double startPrice;
    @DatabaseField
    public Date startDate;

    @DatabaseField
    public Date endDate;

    @DatabaseField(canBeNull = false,foreign = true,foreignAutoRefresh = true)
    public User user;
    @DatabaseField(canBeNull = false,foreign = true,foreignAutoRefresh = true,foreignAutoCreate = true)
    public Item item;


    @ForeignCollectionField(eager = true)
    public ForeignCollection<Bid> databaseBids;

    public List<Bid> bids;

    public Auction(){

    }

    public Auction(double startPrice, Date startDate, Date endDate, User user) {
        this.startPrice = startPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public ForeignCollection<Bid> getDatabaseBids() {
        return databaseBids;
    }

    public void setDatabaseBids(ForeignCollection<Bid> databaseBids) {
        this.databaseBids = databaseBids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", startPrice=" + startPrice +
                ", item=" + item;
    }
}

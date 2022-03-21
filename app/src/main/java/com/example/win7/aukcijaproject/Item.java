package com.example.win7.aukcijaproject;


import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;

@DatabaseTable(tableName = "items")
public class Item implements Serializable {

    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    public String name;
    @DatabaseField
    public String description;
    @DatabaseField
    public String picture;
    @DatabaseField
    public boolean sold;

    @ForeignCollectionField(eager = true)
    public ForeignCollection<Auction> auctions;

    public List<Auction> itemauctions;

    public Item() {

    }

    public Item(String name, String description, String picture) {
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.sold = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public ForeignCollection<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(ForeignCollection<Auction> auctions) {
        this.auctions = auctions;
    }

    public List<Auction> getItemauctions() {
        return itemauctions;
    }

    public void setItemauctions(List<Auction> itemauctions) {
        this.itemauctions = itemauctions;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

package com.example.win7.aukcijaproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by win7 on 24.5.2017.
 */

public interface RestService {

    //                  USERS                   ////////////////////////////////////////////////////////

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET("/users")
    Call<List<User>> getUsers();

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET("/users/{user}")
    Call<User> getUser(@Path("user") int id);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @POST("/users/")
    Call<User> createUser(@Body User user);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @PUT("/users/{id}")
    Call<User> updateUser(@Path("id") int id);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @DELETE("/users/{id}")
    Call<User> deleteUser(@Path("id") int id);
////////////////////////////////////////////////////////


    //                  ITEMS                   ////////////////////////////////////////////////////////

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET("items")
    Call<List<Item>> getItems();

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET("/items/{item}")
    Call<Item> getItem(@Path("item") int id);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @POST("/items/")
    Call<Item> createItem(@Body Item item);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @PUT("/items/{id}")
    Call<Item> updateItem(@Path("id") int id);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @DELETE("/items/{id}")
    Call<Item> deleteItem(@Path("id") int id);
////////////////////////////////////////////////////////


    //                  BIDS                   ////////////////////////////////////////////////////////

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET("/bids")
    Call<List<Bid>> getBids();

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET("/bids/{bid}")
    Call<Bid> getBid(@Path("bid") int id);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @POST("/bids/")
    Call<Bid> createBid(@Body Bid bid);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @PUT("/bids/{id}")
    Call<Bid> updateBid(@Path("id") int id);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @DELETE("/bids/{id}")
    Call<Bid> deleteBid(@Path("id") int id);
////////////////////////////////////////////////////////



    //                  AUCTIONS                   ////////////////////////////////////////////////////////

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET("/auctions")
    Call<List<Auction>> getAuctions();

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET("/auctions/{auction}")
    Call<Auction> getAuction(@Path("auction") int id);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @POST("/auctions/")
    Call<Auction> createAuction(@Body Auction auction);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @PUT("/auctions/{id}")
    Call<Auction> updateAuction(@Path("id") int id);

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @DELETE("/auctions/{id}")
    Call<Auction> deleteAuction(@Path("id") int id);
////////////////////////////////////////////////////////
}

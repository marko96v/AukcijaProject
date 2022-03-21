package com.example.win7.aukcijaproject;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AuctionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auction);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Auction Activity");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Auction selectedAuction = (Auction) getIntent().getSerializableExtra("selectedAuction");

        TextView textViewStartPrice = (TextView) findViewById(R.id.textViewAuctionStartPrice);
        textViewStartPrice.setText(String.valueOf(selectedAuction.getStartPrice()));

        TextView textViewStartDate = (TextView) findViewById(R.id.textViewAuctionStartDate);
        textViewStartDate.setText(String.valueOf(selectedAuction.getStartDate()));

        TextView textViewEndDate = (TextView) findViewById(R.id.textViewAuctionEndDate);
        textViewEndDate.setText(String.valueOf(selectedAuction.getEndDate()));

        TextView textViewEmail = (TextView) findViewById(R.id.textViewAuctionUserEmail);
        textViewEmail.setText(selectedAuction.getUser().toString());

        TextView textViewItem = (TextView) findViewById(R.id.textViewAuctionItem);
        textViewItem.setText(selectedAuction.getItem().toString());

        /*TextView textViewBids = (TextView) findViewById(R.id.textViewAuctionBids);
        textViewBids.setText(String.valueOf(selectedAuction.getBids().size()));

        textViewBids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AuctionActivity.this, "Not Ready Yet!", Toast.LENGTH_SHORT).show();
            }
        }); */

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
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

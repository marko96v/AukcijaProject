package com.example.win7.aukcijaproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Item Activity");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Item selectedItem = (Item) getIntent().getSerializableExtra("selectedItem");

        TextView textViewItemName = (TextView) findViewById(R.id.textViewItemName);
        textViewItemName.setText(selectedItem.getName());

        TextView textViewItemDesc = (TextView) findViewById(R.id.textViewItemDescription);
        textViewItemDesc.setText(selectedItem.getDescription());

       /* TextView textViewItemSold = (TextView) findViewById(R.id.textViewItemSold);
        textViewItemSold.setText(String.valueOf(selectedItem.isSold()));*/

      /*  ImageView imageViewItemImage = (ImageView) findViewById(R.id.imageViewItemImage);
        imageViewItemImage.setImageResource(selectedItem.getPicture());*/

        Button bt = (Button) findViewById(R.id.btnunos);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext() ,"Uspesno ste poslali ponudu!",Toast.LENGTH_LONG).show();
                Intent i = new Intent(ItemActivity.this,AuctionService.class);
                startService(i);

            }
        });

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

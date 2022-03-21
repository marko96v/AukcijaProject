package com.example.win7.aukcijaproject;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuctionsFragment extends Fragment {

   /* private User tmpUser = new User(1, "Test", "asdsd@gmail.com", "pass",
            null, "Adresa", "021/555-333");


    private ArrayList<Auction> auctions = new ArrayList<>(Arrays.asList(
       new Auction(1, 1500, new Date(), tmpUser, ItemsFragment.items.get(0)),
       new Auction(2, 55000, new Date(), tmpUser, ItemsFragment.items.get(1)),
       new Auction(3, 555333, new Date(), tmpUser, ItemsFragment.items.get(2))
    ));*/

    public AuctionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_auctions, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.auctionsList);

        listView.setAdapter(new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_list_item_1, mokap.getAuctions()));



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openAuctionActivity(mokap.getAuctions().get(position));
            }
        });


        return rootView;
    }

    private void openAuctionActivity(Auction selectedAuction){
        Intent intent = new Intent(getActivity(), AuctionActivity.class);
        intent.putExtra("selectedAuction", selectedAuction);
        startActivity(intent);
    }

}

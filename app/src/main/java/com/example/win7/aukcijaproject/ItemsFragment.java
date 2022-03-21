package com.example.win7.aukcijaproject;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {

    /*public static ArrayList<Item> items = new ArrayList<>(Arrays.asList(
        new Item(1, "Predmet 1", "Opis za prvi", R.drawable.ic_launcher, false),
        new Item(2, "Predmet 2", "Opis za drugi", R.drawable.ic_launcher, false),
        new Item(3, "Predmet 3", "Opis za treci", R.drawable.ic_launcher, false)
    ));*/

    public ItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_items, container, false);


        ListView listView = (ListView) rootView.findViewById(R.id.itemList);
        listView.setAdapter(new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_list_item_1, mokap.getItems()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openItemActivity(mokap.getItems().get(position));
            }
        });

        return rootView;
    }

    private void openItemActivity(Item selectedItem){
        Intent intent = new Intent(getActivity(), ItemActivity.class);
        intent.putExtra("selectedItem", selectedItem);
        startActivity(intent);
    }

}

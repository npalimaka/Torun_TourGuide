package com.example.android.torun_tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Hotels, hostels and apartments in Toruń.
 * Each pinned to goggle map when clicked.
 */
public class HotelsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);
        final ArrayList<Attraction> hotels = new ArrayList<>();

        hotels.add(new Attraction(R.string.hotel1, R.string.holtel1_details, R.drawable.hotel1,
                "geo:0,0?q=1600 1231 Hotel, Torun, Poland"));
        hotels.add(new Attraction(R.string.bulwar, R.string.bulwar_details, R.drawable.bulwar,
                "geo:0,0?q=1600 Hotel Bulwar, Torun, Poland"));
        hotels.add(new Attraction(R.string.hotel_copernicus, R.string.hotel_copernicus_details, R.drawable.hotel_copernicus,
                "geo:0,0?q=1600 Copernicus Hotel, Torun, Poland"));
        hotels.add(new Attraction(R.string.mercure, R.string.mercure_details, R.drawable.mercure,
                "geo:0,0?q=1600 Mercure, Torun, Poland"));
        hotels.add(new Attraction(R.string.filmar, R.string.filmar_details, R.drawable.filmar,
                "geo:0,0?q=1600 Hotel Filmar, Torun, Poland"));
        hotels.add(new Attraction(R.string.nova, R.string.nova_details, R.drawable.nova,
                "geo:0,0?q=1600 Nova Apartamenty, Torun, Poland"));
        hotels.add(new Attraction(R.string.roze, R.string.roze_details, R.drawable.roze,
                "geo:0,0?q=1600 Roze i Zen, Torun, Poland"));
        hotels.add(new Attraction(R.string.freedom, R.string.freedom_details, R.drawable.freedom,
                "geo:0,0?q=1600 Freedom Hostel, Torun, Poland"));
        hotels.add(new Attraction(R.string.mcsm, R.string.mcsm_details, R.drawable.mcsm,
                "geo:0,0?q=1600 Miedzynarodowe Centrum Spotkan Mlodziezy, Torun, Poland"));

        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), hotels, new MyOnClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Uri gmmIntentUri = Uri.parse(hotels.get(position).getMAddress());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);
        return rootView;
    }
}

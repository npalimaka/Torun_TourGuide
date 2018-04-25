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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);
        final ArrayList<Attraction> restaurants = new ArrayList<>();

        restaurants.add(new Attraction(R.string.chleb, R.string.chleb_details, R.drawable.chleb,
                "geo:0,0?q=1600 Chleb i Wino, Torun, Poland"));
        restaurants.add(new Attraction(R.string.olbracht, R.string.olbracht_details, R.drawable.olbracht,
                "geo:0,0?q=1600 Jan Olbracht Browar Staromiejski, Torun, Poland"));
        restaurants.add(new Attraction(R.string.loft, R.string.loft_details, R.drawable.loft,
                "geo:0,0?q=1600 Loft79, Torun, Poland"));
        restaurants.add(new Attraction(R.string.manekin, R.string.manekin_details, R.drawable.manekin,
                "geo:0,0?q=1600 Manekin, Torun, Poland"));
        restaurants.add(new Attraction(R.string.stary, R.string.stary_details, R.drawable.stary,
                "geo:0,0?q=1600 Pierogarnia Stary Torun, Torun, Poland"));
        restaurants.add(new Attraction(R.string.lenkiewicz, R.string.lenkiewicz_details, R.drawable.lenkiewicz,
                "geo:0,0?q=1600 Cukiernia Lenkiewicz, Torun, Poland"));
        restaurants.add(new Attraction(R.string.arkadami, R.string.arkadami_details, R.drawable.mleczny,
                "geo:0,0?q=1600 Pod Arkadami, Torun, Poland"));
        restaurants.add(new Attraction(R.string.carpe, R.string.carpe_details, R.drawable.carpe,
                "geo:0,0?q=1600 Carpe Kraft, Torun, Poland"));

        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), restaurants, new MyOnClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Uri gmmIntentUri = Uri.parse(restaurants.get(position).getMAddress());
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

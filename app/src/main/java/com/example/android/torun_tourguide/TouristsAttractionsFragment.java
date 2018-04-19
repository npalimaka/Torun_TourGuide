package com.example.android.torun_tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class TouristsAttractionsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public TouristsAttractionsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(R.string.copernicus,
                R.string.copernicus_details, R.drawable.copernicus_monument,
                "geo:0,0?q=1600 Nicolaus Copernicus Monument, Torun, Poland"));
        attractions.add(new Attraction(R.string.tower, R.string.tower_details, R.drawable.leaning_tower,
                "geo:0,0?q=1600 The Leaning Tower, Torun, Poland"));
        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), attractions, new MyOnClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Uri gmmIntentUri = Uri.parse(attractions.get(position).getMAddress());
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

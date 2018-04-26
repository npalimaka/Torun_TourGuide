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
 * Top monuments to see in Torun.
 * Each pinned to goggle map when clicked.
 */
public class MonumentsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public MonumentsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        final ArrayList<Attraction> monuments = new ArrayList<>();
        monuments.add(new Attraction(R.string.copernicus,
                R.string.copernicus_details, R.drawable.copernicus_monument,
                "geo:0,0?q=1600 Nicolaus Copernicus Monument, Torun, Poland"));
        monuments.add(new Attraction(R.string.tower, R.string.tower_details, R.drawable.leaning_tower,
                "geo:0,0?q=1600 The Leaning Tower, Torun, Poland"));
        monuments.add(new Attraction(R.string.town_hall, R.string.hall_details, R.drawable.town_hall,
                "geo:0,0?q=1600 The Old Town Hall, Torun, Poland"));
        monuments.add(new Attraction(R.string.copernicus_house, R.string.house_details, R.drawable.copernicus_house,
                "geo:0,0?q=1600 House of Nicolaus Copernicus, Torun, Poland"));
        monuments.add(new Attraction(R.string.castle, R.string.castle_details, R.drawable.castle,
                "geo:0,0?q=1600 Teutonic Knight Castle, Torun, Poland"));
        monuments.add(new Attraction(R.string.gate, R.string.gate_details, R.drawable.bridge_gate,
                "geo:0,0?q=1600 Brama Mostowa, Torun, Poland"));
        monuments.add(new Attraction(R.string.cathedral, R.string.cathedral_details, R.drawable.cathedral,
                "geo:0,0?q=1600 SS Johns Cathedral, Torun, Poland"));
        monuments.add(new Attraction(R.string.gingerbread, R.string.gingerbread_details, R.drawable.gingerbread,
                "geo:0,0?q=1600 Gingerbread Museum, Torun, Poland"));
        monuments.add(new Attraction(R.string.convent, R.string.convent_details, R.drawable.convent_gate,
                "geo:0,0?q=1600 Brama Klasztorna, Torun, Poland"));
        monuments.add(new Attraction(R.string.holy_spirit, R.string.holy_spirit_detail, R.drawable.holy_spirit,
                "geo:0,0?q=1600 Holy Spirit Church, Torun, Poland"));
        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), monuments, new MyOnClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Uri gmmIntentUri = Uri.parse(monuments.get(position).getMAddress());
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

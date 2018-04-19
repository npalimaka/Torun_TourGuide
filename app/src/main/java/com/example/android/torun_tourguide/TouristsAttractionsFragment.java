package com.example.android.torun_tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TouristsAttractionsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public TouristsAttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        final ArrayList<Attraction> test = new ArrayList<>();
        test.add(new Attraction("Nicolaus Copernicus Monument",
                "One of the most important symbols of Torun", R.drawable.copernicus_monument, "https://www.google.com/maps/place/Pomnik+Miko%C5%82aja+Kopernika/@53.0103001,18.604965,15z/data=!4m5!3m4!1s0x0:0x2f3093f0cb48dbe8!8m2!3d53.0103001!4d18.604965"));
        test.add(new Attraction("TestII", "test", "test"));
        test.add(new Attraction("Hmm", "tdfd", "tdd"));
        AttractionsAdapter adapterr = new AttractionsAdapter(test, recyclerView);
        recyclerView = rootView.findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapterr);

        return rootView;
    }

}

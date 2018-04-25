package com.example.android.torun_tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);
        final ArrayList<Attraction> events = new ArrayList<>();
        String location = "Torun, Poland";

        events.add(new Attraction(R.string.skyway, R.string.skyway_details,
                "Torun, Poland"));
        events.add(new Attraction(R.string.sff, R.string.sff_details, location));
        events.add(new Attraction(R.string.copernicon, R.string.copernicon_details, location));
        events.add(new Attraction(R.string.blues, R.string.blues_details, location));
        events.add(new Attraction(R.string.koncerty, R.string.koncerty_details, location));
        events.add(new Attraction(R.string.forte, R.string.forte_details, location));
        events.add(new Attraction(R.string.lalek, R.string.lalek_details, location));
        events.add(new Attraction(R.string.tofifest, R.string.tofifest_details, location));

        // Opening the calendar via intent to add a specified event
        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), events, new MyOnClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                String name = getString(events.get(position).getMAttractionName());
                calIntent.putExtra(CalendarContract.Events.TITLE, name);
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, events.get(position).getMAddress());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

                startActivity(calIntent);
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

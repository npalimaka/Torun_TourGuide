package com.example.android.torun_tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionsAdapter extends RecyclerView.Adapter {

    private ArrayList<Attraction> attractionArraList;
    private RecyclerView recyclerView;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTitle;
        public TextView mDetails;
        public ImageView mPhoto;

        public ViewHolder(View pItem) {
            super(pItem);
            mTitle = (TextView) pItem.findViewById(R.id.attraction_name);
            mDetails = pItem.findViewById(R.id.attraction_details);
            mPhoto = pItem.findViewById(R.id.location_photo);
        }
    }

    public AttractionsAdapter(ArrayList<Attraction> attractions, RecyclerView recyclerView) {
        this.attractionArraList = new ArrayList<>(attractions);
        this.recyclerView = recyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final
    int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Attraction attraction = attractionArraList.get(position);
        ((ViewHolder) holder).mTitle.setText(attractionArraList.get(position).getMAttractionName());
        ((ViewHolder) holder).mDetails.setText(attractionArraList.get(position).getMDescription());
        //nie działa...
        if (attraction.hasImage()) {
            ((ViewHolder) holder).mPhoto.setImageResource(attractionArraList.get(position).getMImageResourceID());
            ((ViewHolder) holder).mPhoto.setVisibility(View.VISIBLE);
        } else {
            ((ViewHolder) holder).mPhoto.setVisibility(View.GONE);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return attractionArraList.size();
    }
}

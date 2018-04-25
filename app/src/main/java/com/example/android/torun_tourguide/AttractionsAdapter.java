package com.example.android.torun_tourguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This class is responsible for connecting all views to their resources
 */
public class AttractionsAdapter extends RecyclerView.Adapter {

    private Context context;
    private MyOnClickListener listener;
    private ArrayList<Attraction> attractionArraList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.attraction_name)
        TextView mTitle;
        @BindView(R.id.attraction_details)
        TextView mDetails;
        @BindView(R.id.location_photo)
        ImageView mPhoto;
        @BindView(R.id.place_icon)
        ImageView test;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public AttractionsAdapter(Context context, ArrayList<Attraction> attractions, MyOnClickListener listener) {
        this.attractionArraList = new ArrayList<>(attractions);
        this.context = context;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final
    int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        final ViewHolder mViewHolder = new ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, mViewHolder.getLayoutPosition());
            }
        });
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Attraction attraction = attractionArraList.get(position);
        ((ViewHolder) holder).mTitle.setText(attractionArraList.get(position).getMAttractionName());
        ((ViewHolder) holder).mDetails.setText(attractionArraList.get(position).getMDescription());

        if (attraction.hasImage()) {
            ((ViewHolder) holder).mPhoto.setImageResource(attractionArraList.get(position).getMImageResourceID());
            ((ViewHolder) holder).mPhoto.setVisibility(View.VISIBLE);
        } else {
            ((ViewHolder) holder).mPhoto.setVisibility(View.GONE);
            ((ViewHolder) holder).test.setImageResource(R.drawable.ic_event_white_24dp);
        }
    }

    @Override
    public int getItemCount() {
        return attractionArraList.size();
    }
}

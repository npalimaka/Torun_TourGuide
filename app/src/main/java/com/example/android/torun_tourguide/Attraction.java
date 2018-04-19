package com.example.android.torun_tourguide;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents locations, hotels, restaurants, events.
 */
@Getter
@Setter
@AllArgsConstructor
public class Attraction {

    private final int NO_IMAGE_PROVIDED = -1;
    private String mAttractionName;
    private String mDescription;
    private int mImageResourceID;
    private String mAddress;

    public Attraction(String name, String description, String address){
        this.mAttractionName = name;
        this.mDescription = description;
        this.mAddress = address;
    }
    public boolean hasImage(){
        return this.mImageResourceID != NO_IMAGE_PROVIDED;
    }
}

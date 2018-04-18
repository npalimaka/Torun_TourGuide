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

    private String attractionName;
    private String description;
    private int imageResourceID;
    private String address;

    public Attraction(String name, String description, String address){
        this.attractionName = name;
        this.description = description;
        this.address = address;
    }
}

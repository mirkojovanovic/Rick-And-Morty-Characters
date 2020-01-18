package com.example.android.mj_rickandmorty.models;

import com.google.gson.annotations.SerializedName;

public class Episode {
    @SerializedName("air_date")
    private String airDate;
    private String name;
    private String episode;
    private int id;

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getEpisode() {
        return episode;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

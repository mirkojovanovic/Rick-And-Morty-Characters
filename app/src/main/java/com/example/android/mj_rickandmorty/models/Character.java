package com.example.android.mj_rickandmorty.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Character implements Parcelable {
    private String image;
    private String gender;
    private String species;
    private String name;
    private List<String> episode;
    private int id;
    private String url;

    private Character(Parcel in) {
        image = in.readString();
        gender = in.readString();
        species = in.readString();
        name = in.readString();
        episode = in.createStringArrayList();
        id = in.readInt();
        url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(gender);
        dest.writeString(species);
        dest.writeString(name);
        dest.writeStringList(episode);
        dest.writeInt(id);
        dest.writeString(url);
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
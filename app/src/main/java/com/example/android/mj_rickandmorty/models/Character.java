package com.example.android.mj_rickandmorty.models;

import java.util.List;

public class Character {
	private String image;
	private String gender;
	private String species;
	private String name;
	private List<String> episode;
	private int id;
	private String url;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setSpecies(String species){
		this.species = species;
	}

	public String getSpecies(){
		return species;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEpisode(List<String> episode){
		this.episode = episode;
	}

	public List<String> getEpisode(){
		return episode;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}
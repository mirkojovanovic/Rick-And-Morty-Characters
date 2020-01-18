package com.example.android.mj_rickandmorty.models;

import java.util.List;

public class Episodes {
	private List<Episode> results;

	public void setResults(List<Episode> results){
		this.results = results;
	}

	public List<Episode> getResults(){
		return results;
	}
}
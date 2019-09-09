package com.movie_phoenix.MoviePhoenix.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TVShowResults {

	
	private ArrayList<TvShow> results;

	public TVShowResults() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<TvShow> getResults() {
		return results;
	}

	public void setResults(ArrayList<TvShow> results) {
		this.results = results;
	}
	
	
	
	
}

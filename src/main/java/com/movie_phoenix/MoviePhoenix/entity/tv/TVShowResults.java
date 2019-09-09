package com.movie_phoenix.MoviePhoenix.entity.tv;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TVShowResults {

	private Integer numResults;
	private ArrayList<TvShow> results;

	public TVShowResults() {
		super();
	}

	public ArrayList<TvShow> getResults() {
		return results;
	}

	public void setResults(ArrayList<TvShow> results) {
		this.results = results;
	}

	public Integer getNumResults() {
		return numResults;
	}

	public void setNumResults(Integer numResults) {
		this.numResults = numResults;
	}
	
	
}

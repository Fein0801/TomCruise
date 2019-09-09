package com.movie_phoenix.MoviePhoenix.entity.movie;

import java.util.ArrayList;

public class MovieResults {
	
	private Integer numResults;
	private ArrayList<Movie> results;
	
	public MovieResults() {
		super();
	}

	public Integer getNumResults() {
		return numResults;
	}

	public void setNumResults(Integer numResults) {
		this.numResults = numResults;
	}

	public ArrayList<Movie> getResults() {
		return results;
	}

	public void setResults(ArrayList<Movie> results) {
		this.results = results;
	}
	
	
}

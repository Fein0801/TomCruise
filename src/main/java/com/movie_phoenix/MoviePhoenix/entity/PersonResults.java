package com.movie_phoenix.MoviePhoenix.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonResults {
	private ArrayList<Person> results;

	public PersonResults() {
		super();
	}

	public ArrayList<Person> getResults() {
		return results;
	}

	public void setResults(ArrayList<Person> results) {
		this.results = results;
	}
}

package com.movie_phoenix.MoviePhoenix.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvCreditsByTitle {
	private Integer Id;
	private ArrayList<Person> cast;
	private ArrayList<Person> crew;
	public TvCreditsByTitle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public ArrayList<Person> getCast() {
		return cast;
	}
	public void setCast(ArrayList<Person> cast) {
		this.cast = cast;
	}
	public ArrayList<Person> getCrew() {
		return crew;
	}
	public void setCrew(ArrayList<Person> crew) {
		this.crew = crew;
	}

}

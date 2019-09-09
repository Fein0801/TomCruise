package com.movie_phoenix.MoviePhoenix.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvCreditsByPerson {
	private Integer Id;
	private ArrayList<TvShow> cast;
	private ArrayList<TvShow> crew;
	public TvCreditsByPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public ArrayList<TvShow> getCast() {
		return cast;
	}
	public void setCast(ArrayList<TvShow> cast) {
		this.cast = cast;
	}
	public ArrayList<TvShow> getCrew() {
		return crew;
	}
	public void setCrew(ArrayList<TvShow> crew) {
		this.crew = crew;
	}
	
}

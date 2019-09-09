package com.movie_phoenix.MoviePhoenix.entity.tv;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvCreditsByPerson {
	@JsonProperty("Id")
	private Integer actorId;
	private ArrayList<TvShow> cast;
	private ArrayList<TvShow> crew;
	public TvCreditsByPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return actorId;
	}
	public void setId(Integer id) {
		actorId = id;
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

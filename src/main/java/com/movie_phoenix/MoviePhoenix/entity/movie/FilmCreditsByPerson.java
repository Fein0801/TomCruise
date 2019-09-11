package com.movie_phoenix.MoviePhoenix.entity.movie;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmCreditsByPerson {
	@JsonProperty("Id")
	private Integer actorId;
	private ArrayList<Movie> cast;
	private ArrayList<Movie> crew;
	
	public FilmCreditsByPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public ArrayList<Movie> getCast() {
		return cast;
	}
	public void setCast(ArrayList<Movie> cast) {
		this.cast = cast;
	}
	public ArrayList<Movie> getCrew() {
		return crew;
	}
	public void setCrew(ArrayList<Movie> crew) {
		this.crew = crew;
	}

	@Override
	public String toString() {
		return "FilmCreditsByPerson , cast=" + cast + ", crew=" + crew + "]";
	}
	
	

}

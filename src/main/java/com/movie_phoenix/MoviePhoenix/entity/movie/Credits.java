package com.movie_phoenix.MoviePhoenix.entity.movie;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown=true)
public class Credits {
	// class specifically for movie credits utilizing the film id
	@JsonProperty("id")
	private Integer creditId;
	private ArrayList<MovieCast> cast;
	private ArrayList<MovieCrew> crew;
	public Credits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCreditId() {
		return creditId;
	}
	public void setCreditId(Integer creditId) {
		this.creditId = creditId;
	}
	public ArrayList<MovieCast> getCast() {
		return cast;
	}
	public void setCast(ArrayList<MovieCast> cast) {
		this.cast = cast;
	}
	public ArrayList<MovieCrew> getCrew() {
		return crew;
	}
	public void setCrew(ArrayList<MovieCrew> crew) {
		this.crew = crew;
	}

}

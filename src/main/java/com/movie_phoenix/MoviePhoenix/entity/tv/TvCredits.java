package com.movie_phoenix.MoviePhoenix.entity.tv;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)
public class TvCredits {
	@JsonProperty("id")
	private Integer tvId;
	@JsonProperty("cast")
	private ArrayList<TvCast> cast;
	@JsonProperty("crew")
	private ArrayList<TvCrew> crew;
	public TvCredits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getTvId() {
		return tvId;
	}
	public void setTvId(Integer tvId) {
		this.tvId = tvId;
	}
	public ArrayList<TvCast> getCast() {
		return cast;
	}
	public void setCast(ArrayList<TvCast> cast) {
		this.cast = cast;
	}
	public ArrayList<TvCrew> getCrew() {
		return crew;
	}
	public void setCrew(ArrayList<TvCrew> crew) {
		this.crew = crew;
	}

}

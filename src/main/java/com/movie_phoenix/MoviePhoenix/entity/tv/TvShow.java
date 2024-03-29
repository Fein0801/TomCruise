package com.movie_phoenix.MoviePhoenix.entity.tv;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TvShow {

	private Integer id;
	private String name;
	@JsonProperty("first_air_date")
	private String firstAirDate;
	@JsonProperty("poster_path")
	private String imageUrl;
	private String overview;
	@JsonProperty("genres")
	private ArrayList<Tvgenres> genres;
	@JsonProperty("last_air_date")
	private String lastAirDate;
	private String character;
	

	public TvShow() {
		super();
	}
	public String getLastAirDate() {
		return lastAirDate;
	}
	
	public void setLastAirDate(String lastAirDate) {
		this.lastAirDate = lastAirDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public void setFirstAirDate(String firstAirDate) {
		this.firstAirDate = firstAirDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	
	public ArrayList<Tvgenres> getGenres() {
		return genres;
	}
	public void setGenres(ArrayList<Tvgenres> genres) {
		this.genres = genres;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	
	
	
	
}

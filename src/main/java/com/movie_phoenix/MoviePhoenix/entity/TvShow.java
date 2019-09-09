package com.movie_phoenix.MoviePhoenix.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TvShow {

	private Integer id;
	private String name;
	@JsonProperty("first_air_date")
	private String firstAirDate;
	@JsonProperty("poster_path")
	private String imageUrl;
	private String overview;
	@JsonProperty("genre_ids")
	private ArrayList<Integer> genreIds;
	
	public TvShow() {
		super();
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

	public ArrayList<Integer> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(ArrayList<Integer> genreIds) {
		this.genreIds = genreIds;
	}
	
	
	
	
}

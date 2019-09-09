package com.movie_phoenix.MoviePhoenix.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TvPage {

	private Integer id;
	private String name;
	@JsonProperty("first_air_date")
	private String firstAirDate;
	@JsonProperty("poster_path")
	private String imageUrl;
	private String overview;
	
}

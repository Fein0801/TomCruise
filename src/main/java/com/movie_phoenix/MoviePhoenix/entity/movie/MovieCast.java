package com.movie_phoenix.MoviePhoenix.entity.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)
public class MovieCast {
	private String character;
	private String name;
	@JsonProperty("id")
	private Integer castId;
	private Integer order;
	@JsonProperty("profile_path")
	private String profilePath;
	public MovieCast() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getCharacter() {
		return character;
	}


	public void setCharacter(String character) {
		this.character = character;
	}


	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCastId() {
		return castId;
	}
	public void setCastId(Integer castId) {
		this.castId = castId;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}

}

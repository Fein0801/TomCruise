/**
 * 
 */
package com.movie_phoenix.MoviePhoenix.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie_phoenix.MoviePhoenix.entity.movie.Movie;

/**
 * @author Atiba
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class Person {

	private Integer Id;
	private String name;
	@JsonProperty("Known_for_department")
	private String department;
	@JsonProperty("profile_path")
	private String imageUrl;
	@JsonProperty("Known_for")
	List<Movie> knownFor;
	private String birthday;
	private String deathday;
	@JsonProperty("imdb_id")
	private String imdb;
	private String biography;
	@JsonProperty("place_of_birth")
	private String placeOfBirth;

	public Person() {
		super();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Movie> getKnownFor() {
		return knownFor;
	}

	public void setKnownFor(List<Movie> knownFor) {
		this.knownFor = knownFor;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDeathday() {
		return deathday;
	}

	public void setDeathday(String deathday) {
		this.deathday = deathday;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

}

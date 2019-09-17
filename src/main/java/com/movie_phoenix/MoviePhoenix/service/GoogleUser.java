package com.movie_phoenix.MoviePhoenix.service;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.movie_phoenix.MoviePhoenix.entity.FavsActor;
import com.movie_phoenix.MoviePhoenix.entity.movie.FavsMovie;
import com.movie_phoenix.MoviePhoenix.entity.tv.FavsTv;

@Entity
@Table(name = "user")
public class GoogleUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entryId;
	private String email;
	private String name;
	private String calendarId;
	private String firstName;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER) // , cascade = CascadeType.ALL, orphanRemoval = true
	private List<FavsActor> favActors;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER) // , cascade = CascadeType.ALL, orphanRemoval = true
	private List<FavsMovie> favMovies;
	@OneToMany(mappedBy = "userTv", fetch = FetchType.EAGER) // , cascade = CascadeType.ALL, orphanRemoval = true
	private List<FavsTv> favTv;

	public GoogleUser() {
		super();
	}

	public GoogleUser(Integer entryId, String email, String name, String calendarId, String firstName,
			List<FavsActor> favActors) {
		super();
		this.entryId = entryId;
		this.email = email;
		this.name = name;
		this.calendarId = calendarId;
		this.firstName = firstName;
		this.favActors = favActors;
	}

	public GoogleUser(String email, String name, String calendarId, String firstName, List<FavsActor> favActors) {
		super();
		this.email = email;
		this.name = name;
		this.calendarId = calendarId;
		this.firstName = firstName;
		this.favActors = favActors;
	}

	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(String calendarId) {
		this.calendarId = calendarId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<FavsActor> getFavActors() {
		return favActors;
	}

	public void setFavActors(List<FavsActor> favActors) {
		this.favActors = favActors;
	}

}

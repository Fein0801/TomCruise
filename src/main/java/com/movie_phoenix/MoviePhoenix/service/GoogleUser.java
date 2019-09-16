package com.movie_phoenix.MoviePhoenix.service;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.movie_phoenix.MoviePhoenix.entity.FavsActor;

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
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FavsActor> favActors;

	public GoogleUser() {
		super();
	}

	public GoogleUser(Integer entryId, String email, String name, String calendarId, String firstName) {
		super();
		this.entryId = entryId;
		this.email = email;
		this.name = name;
		this.calendarId = calendarId;
		this.firstName = firstName;
	}

	public GoogleUser(String email, String name, String calendarId, String firstName) {
		super();
		this.email = email;
		this.name = name;
		this.calendarId = calendarId;
		this.firstName = firstName;
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

}

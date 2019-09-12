package com.movie_phoenix.MoviePhoenix.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class GoogleUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entryId;
	private String email;
	private String name;
	private String calendarId;

	public GoogleUser() {
		super();
	}

	public GoogleUser(String email, String name, String calendarId) {
		super();
		this.email = email;
		this.name = name;
		this.calendarId = calendarId;
	}

	public GoogleUser(Integer entryId, String email, String name, String calendarId) {
		super();
		this.entryId = entryId;
		this.email = email;
		this.name = name;
		this.calendarId = calendarId;
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

}

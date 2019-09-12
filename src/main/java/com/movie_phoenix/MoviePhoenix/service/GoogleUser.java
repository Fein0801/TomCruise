package com.movie_phoenix.MoviePhoenix.service;


public class GoogleUser {

	private Integer entryId;
	private String email;
	private String name;

	public GoogleUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoogleUser(Integer entryId, String email, String name) {
		super();
		this.entryId = entryId;
		this.email = email;
		this.name = name;
	}

	public GoogleUser(String email, String name) {
		super();
		this.email = email;
		this.name = name;
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

}

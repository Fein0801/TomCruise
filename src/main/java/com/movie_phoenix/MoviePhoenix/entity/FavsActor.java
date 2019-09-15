package com.movie_phoenix.MoviePhoenix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FavsActor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entryId;
	private Integer actorId;
	private Integer userId;
	private String name;
	private String imageUrl;

	public FavsActor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FavsActor(Integer entryId, Integer actorId, Integer userId, String name, String imageUrl) {
		super();
		this.entryId = entryId;
		this.actorId = actorId;
		this.userId = userId;
		this.name = name;
		this.imageUrl = imageUrl;
	}

	public FavsActor(Integer actorId, Integer userId, String name, String imageUrl) {
		super();
		this.actorId = actorId;
		this.userId = userId;
		this.name = name;
		this.imageUrl = imageUrl;
	}

	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}

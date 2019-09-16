package com.movie_phoenix.MoviePhoenix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.movie_phoenix.MoviePhoenix.service.GoogleUser;

@Entity
@Table(name = "fav_actor")
public class FavsActor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entryId;
	private Integer actorId;
	private String name;
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "user_id_fk")
	private GoogleUser user;

	public FavsActor() {
		super();
	}

	public FavsActor(Integer entryId, Integer actorId, String name, String imageUrl, GoogleUser user) {
		super();
		this.entryId = entryId;
		this.actorId = actorId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.user = user;
	}

	public FavsActor(Integer actorId, String name, String imageUrl, GoogleUser user) {
		super();
		this.actorId = actorId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.user = user;
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

	public GoogleUser getUser() {
		return user;
	}

	public void setUser(GoogleUser user) {
		this.user = user;
	}

	

}

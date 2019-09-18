package com.movie_phoenix.MoviePhoenix.entity.tv;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fav_tv")
public class FavsTv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entryId;
	private Integer tvId;
	private String title;
	private Integer userId;
	private String imageUrl;

	public FavsTv() {
		super();
	}

	public FavsTv(Integer entryId, Integer tvId, String title, Integer userId, String imageUrl) {
		super();
		this.entryId = entryId;
		this.tvId = tvId;
		this.title = title;
		this.userId = userId;
		this.imageUrl = imageUrl;
	}

	public FavsTv(Integer tvId, String title, Integer userId, String imageUrl) {
		super();
		this.tvId = tvId;
		this.title = title;
		this.userId = userId;
		this.imageUrl = imageUrl;
	}

	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public Integer getTvId() {
		return tvId;
	}

	public void setTvId(Integer tvId) {
		this.tvId = tvId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}

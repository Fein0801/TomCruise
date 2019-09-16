package com.movie_phoenix.MoviePhoenix.entity.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fav_movie")
public class FavsMovie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entryId;
	private Integer userId;
	private Integer mediaId;
	private String title;
	private String imageUrl;
	private String summary;

	public FavsMovie() {
		super();
	}

	public FavsMovie(Integer entryId, Integer userId, Integer mediaId, String title, String imageUrl, String summary) {
		super();
		this.entryId = entryId;
		this.userId = userId;
		this.mediaId = mediaId;
		this.title = title;
		this.imageUrl = imageUrl;
		this.summary = summary;
	}

	public FavsMovie(Integer userId, Integer mediaId, String title, String imageUrl, String summary) {
		super();
		this.userId = userId;
		this.mediaId = mediaId;
		this.title = title;
		this.imageUrl = imageUrl;
		this.summary = summary;
	}

	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMediaId() {
		return mediaId;
	}

	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}

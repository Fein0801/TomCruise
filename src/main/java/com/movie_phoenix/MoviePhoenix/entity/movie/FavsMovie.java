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
	private Integer mediaId;
	private Integer userId;
	private String title;
	private String imageUrl;

	public FavsMovie() {
		super();
	}

	

	public FavsMovie(Integer entryId, Integer mediaId, Integer userId, String title, String imageUrl) {
		super();
		this.entryId = entryId;
		this.mediaId = mediaId;
		this.userId = userId;
		this.title = title;
		this.imageUrl = imageUrl;
	}



	public FavsMovie(Integer mediaId, Integer userId, String title, String imageUrl) {
		super();
		this.mediaId = mediaId;
		this.userId = userId;
		this.title = title;
		this.imageUrl = imageUrl;
	}



	public Integer getEntryId() {
		return entryId;
	}

	public void setEntryId(Integer entryId) {
		this.entryId = entryId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}

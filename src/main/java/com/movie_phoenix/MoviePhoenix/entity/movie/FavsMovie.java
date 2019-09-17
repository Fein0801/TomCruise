package com.movie_phoenix.MoviePhoenix.entity.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.movie_phoenix.MoviePhoenix.service.GoogleUser;

@Entity
@Table(name = "fav_movie")
public class FavsMovie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entryId;
	private Integer mediaId;
	private String title;
	private String imageUrl;
	private String summary;
	
	@ManyToOne
	@JoinColumn(name = "user_id_fk")
	private GoogleUser user;

	public FavsMovie() {
		super();
	}

	public FavsMovie(Integer entryId, Integer mediaId, String title, String imageUrl, String summary, GoogleUser user) {
		super();
		this.entryId = entryId;
		this.mediaId = mediaId;
		this.title = title;
		this.imageUrl = imageUrl;
		this.summary = summary;
		this.user = user;
	}

	public FavsMovie(Integer mediaId, String title, String imageUrl, String summary, GoogleUser user) {
		super();
		this.mediaId = mediaId;
		this.title = title;
		this.imageUrl = imageUrl;
		this.summary = summary;
		this.user = user;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public GoogleUser getUser() {
		return user;
	}

	public void setUser(GoogleUser user) {
		this.user = user;
	}
	
	
}

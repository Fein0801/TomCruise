package com.movie_phoenix.MoviePhoenix.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "watchlist")
public class WatchlistItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer userId;
	private Integer mediaId;
	private String summary;
	private String imageUrl;

	@Enumerated(EnumType.STRING)
	private ResultType mediaType;

	public WatchlistItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WatchlistItem(Integer userId, Integer mediaId, String summary, String imageUrl, ResultType mediaType) {
		super();
		this.userId = userId;
		this.mediaId = mediaId;
		this.summary = summary;
		this.imageUrl = imageUrl;
		this.mediaType = mediaType;
	}

	public WatchlistItem(Integer id, Integer userId, Integer mediaId, String summary, String imageUrl,
			ResultType mediaType) {
		super();
		this.id = id;
		this.userId = userId;
		this.mediaId = mediaId;
		this.summary = summary;
		this.imageUrl = imageUrl;
		this.mediaType = mediaType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public ResultType getMediaType() {
		return mediaType;
	}

	public void setMediaType(ResultType mediaType) {
		this.mediaType = mediaType;
	}

}

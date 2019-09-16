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
	private Integer userId;
	private String title;
	private String firstAirDate;
	private String lastAirDate;
	private String summary;

	public FavsTv() {
		super();
	}

	public FavsTv(Integer entryId, Integer tvId, Integer userId, String title, String firstAirDate, String lastAirDate,
			String summary) {
		super();
		this.entryId = entryId;
		this.tvId = tvId;
		this.userId = userId;
		this.title = title;
		this.firstAirDate = firstAirDate;
		this.lastAirDate = lastAirDate;
		this.summary = summary;
	}

	public FavsTv(Integer tvId, Integer userId, String title, String firstAirDate, String lastAirDate, String summary) {
		super();
		this.tvId = tvId;
		this.userId = userId;
		this.title = title;
		this.firstAirDate = firstAirDate;
		this.lastAirDate = lastAirDate;
		this.summary = summary;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public void setFirstAirDate(String firstAirDate) {
		this.firstAirDate = firstAirDate;
	}

	public String getLastAirDate() {
		return lastAirDate;
	}

	public void setLastAirDate(String lastAirDate) {
		this.lastAirDate = lastAirDate;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}

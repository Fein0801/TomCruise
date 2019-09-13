package com.movie_phoenix.MoviePhoenix.entity.tv;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class FavsTv {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private Integer EntryId;
	private Integer UserId;
	private String name;
	@JsonProperty("first_air_date")
	private String firstAirDate;
	@JsonProperty("last_air_date")
	private String lastAirDate;
	
	public FavsTv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FavsTv(Integer id, Integer entryId, Integer userId, String name, String firstAirDate, String lastAirDate) {
		super();
		Id = id;
		EntryId = entryId;
		UserId = userId;
		this.name = name;
		this.firstAirDate = firstAirDate;
		this.lastAirDate = lastAirDate;
	}
	

	public FavsTv(Integer entryId, Integer userId, String name, String firstAirDate, String lastAirDate) {
		super();
		EntryId = entryId;
		UserId = userId;
		this.name = name;
		this.firstAirDate = firstAirDate;
		this.lastAirDate = lastAirDate;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getEntryId() {
		return EntryId;
	}

	public void setEntryId(Integer entryId) {
		EntryId = entryId;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "FavsTv [Id=" + Id + ", EntryId=" + EntryId + ", UserId=" + UserId + ", name=" + name + ", firstAirDate="
				+ firstAirDate + ", lastAirDate=" + lastAirDate + "]";
	}
	
	
	
}

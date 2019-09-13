package com.movie_phoenix.MoviePhoenix.entity.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class FavsMovie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private Integer EntryId;
	private Integer UserId;
	@JsonProperty("original_title")
	private String ogTitle;
	@JsonProperty("release_date")
	private String releaseDate;
	private Integer runtime;
	
	public FavsMovie() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public FavsMovie(Integer id, Integer entryId, Integer userId, String ogTitle, String releaseDate, Integer runtime) {
		super();
		Id = id;
		EntryId = entryId;
		UserId = userId;
		this.ogTitle = ogTitle;
		this.releaseDate = releaseDate;
		this.runtime = runtime;
	}

	

	public FavsMovie(Integer entryId, Integer userId, String ogTitle, String releaseDate, Integer runtime) {
		super();
		EntryId = entryId;
		UserId = userId;
		this.ogTitle = ogTitle;
		this.releaseDate = releaseDate;
		this.runtime = runtime;
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

	

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}



	public String getOgTitle() {
		return ogTitle;
	}



	public void setOgTitle(String ogTitle) {
		this.ogTitle = ogTitle;
	}



	public Integer getRuntime() {
		return runtime;
	}



	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}



	@Override
	public String toString() {
		return "FavsMovie [Id=" + Id + ", EntryId=" + EntryId + ", UserId=" + UserId + ", ogTitle=" + ogTitle
				+ ", releaseDate=" + releaseDate + ", runtime=" + runtime + "]";
	}

	
	
	
	
	
}

package com.movie_phoenix.MoviePhoenix.entity.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)
public class MovieCrew {
	@JsonProperty("profile_path")
	private String profilePath;
	@JsonProperty("id")
	private Integer crewId;
	private String name;
	private String job;
	private String department;
	public MovieCrew() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	public Integer getCrewId() {
		return crewId;
	}
	public void setCrewId(Integer crewId) {
		this.crewId = crewId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	

}

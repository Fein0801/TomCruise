/**
 * 
 */
package com.movie_phoenix.MoviePhoenix.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author kevinbusch
 *
 */
public class Movie {
	@JsonProperty("poster_path")
	private String posterUrl;
	@JsonProperty("backdrop_path")
	private String backdropUrl;
	@JsonProperty("original_title")
	private String ogTitle;
	private String title;
	private String overview;
	@JsonProperty("release_date")
	private String releaseDate;
	private String Status;
	ArrayList<Genre> genre;
	private Integer id;
	@JsonProperty("imdb_id")
	private String imbd;
	private Long budget;
	private Long revenue;
	private String tagline;
	private Integer runtime;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public String getBackdropUrl() {
		return backdropUrl;
	}

	public void setBackdropUrl(String backdropUrl) {
		this.backdropUrl = backdropUrl;
	}

	public String getOgTitle() {
		return ogTitle;
	}

	public void setOgTitle(String ogTitle) {
		this.ogTitle = ogTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public ArrayList<Genre> getGenre() {
		return genre;
	}

	public void setGenre(ArrayList<Genre> genre) {
		this.genre = genre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImbd() {
		return imbd;
	}

	public void setImbd(String imbd) {
		this.imbd = imbd;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public Long getRevenue() {
		return revenue;
	}

	public void setRevenue(Long revenue) {
		this.revenue = revenue;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

}

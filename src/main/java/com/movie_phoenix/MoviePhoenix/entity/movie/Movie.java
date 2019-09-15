/**
 * 
 */
package com.movie_phoenix.MoviePhoenix.entity.movie;

import java.time.LocalDate;
import java.util.ArrayList;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie_phoenix.MoviePhoenix.entity.Genre;

/**
 * @author kevinbusch
 *
 */


public class Movie implements Comparable<Movie> {
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
	private String status;
	private ArrayList<Genre> genre;
	private Integer id;
	@JsonProperty("imdb_id")
	private String imbd;
	private Long budget;
	private Long revenue;
	private String tagline;
	private Integer runtime;
	private String character;
	
	private ReleaseStatus releaseStatus;

	public Movie() {
		super();
	}
	
	public static enum ReleaseStatus {
		RELEASED, POST_PRODUCTION, PLANNED, PRE_PRODUCTION, UNKNOWN
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
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		this.setReleaseStatus(status);
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
	
	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
	
	public void setReleaseStatus(String status) {
		if(status.equalsIgnoreCase("released")) {
			releaseStatus = ReleaseStatus.RELEASED;
		} else if (status.equalsIgnoreCase("pre production")) {
			releaseStatus = ReleaseStatus.PRE_PRODUCTION;
		}else if(status.equalsIgnoreCase("post production")) {
			releaseStatus = ReleaseStatus.POST_PRODUCTION;
		} else if(status.equalsIgnoreCase("planned")) {
			releaseStatus = ReleaseStatus.PLANNED;
		} else {
			releaseStatus = ReleaseStatus.UNKNOWN;
		}
	}
	
	public void setReleaseStatus(ReleaseStatus status) {
		releaseStatus = status;
	}
	
	public ReleaseStatus getReleaseStatus() {
		return this.releaseStatus;
	}

	@Override
	public int compareTo(Movie movie) {		
		LocalDate date1 = LocalDate.parse(this.getReleaseDate());
		LocalDate date2 = LocalDate.parse(movie.getReleaseDate());
		return date1.compareTo(date2);
	}
}

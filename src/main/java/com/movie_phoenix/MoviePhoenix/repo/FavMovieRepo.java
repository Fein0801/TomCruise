package com.movie_phoenix.MoviePhoenix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie_phoenix.MoviePhoenix.entity.movie.FavsMovie;

public interface FavMovieRepo extends JpaRepository<FavsMovie, Integer> {
	List<FavsMovie> findByUserId(Integer userId);
	
	@Query(value = "select * from fav_movie where media_id=? and user_id=?", nativeQuery = true)
	List<FavsMovie> findByUserAndMovie(Integer movieId, Integer userId);
}

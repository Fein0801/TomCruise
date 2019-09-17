package com.movie_phoenix.MoviePhoenix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie_phoenix.MoviePhoenix.entity.movie.FavsMovie;
import com.movie_phoenix.MoviePhoenix.service.GoogleUser;

public interface FavMovieRepo extends JpaRepository<FavsMovie, Integer> {
	List<FavsMovie> findByUser(GoogleUser user);
	
	@Query(value = "select * from fav_movie where media_id=? and user_id_fk=?", nativeQuery = true)
	List<FavsMovie> findByUserAndMovi(Integer movieId, Integer userId);
}

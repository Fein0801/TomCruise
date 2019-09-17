package com.movie_phoenix.MoviePhoenix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie_phoenix.MoviePhoenix.entity.movie.FavsMovie;

public interface FavMovieRepo extends JpaRepository<FavsMovie, Integer> {
	@Query(value = "select * from fav_actor where media_id=? and user_id_fk=?", nativeQuery = true)
	List<FavsMovie> findByUserAndMovi(Integer movieId, Integer userId);
}

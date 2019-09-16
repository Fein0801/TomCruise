package com.movie_phoenix.MoviePhoenix.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie_phoenix.MoviePhoenix.entity.movie.FavsMovie;

public interface FavMovieRepo extends JpaRepository<FavsMovie, Integer> {

}

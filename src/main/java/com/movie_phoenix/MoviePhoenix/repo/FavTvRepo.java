package com.movie_phoenix.MoviePhoenix.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie_phoenix.MoviePhoenix.entity.tv.FavsTv;



public interface FavTvRepo extends JpaRepository<FavsTv, Integer>{

}

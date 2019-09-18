package com.movie_phoenix.MoviePhoenix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movie_phoenix.MoviePhoenix.entity.tv.FavsTv;

public interface FavTvRepo extends JpaRepository<FavsTv, Integer> {
	List<FavsTv> findByUserId(Integer userId);
	
	@Query(value = "select * from fav_tv where tv_id=? and user_id=?", nativeQuery = true)
	List<FavsTv> findByUserAndShow(Integer tvId, Integer userId);
}

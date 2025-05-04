package com.gayathri.TMDB.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gayathri.TMDB.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

}

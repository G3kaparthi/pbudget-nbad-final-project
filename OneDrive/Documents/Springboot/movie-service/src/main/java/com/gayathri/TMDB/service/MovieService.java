package com.gayathri.TMDB.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gayathri.TMDB.model.Movie;
import com.gayathri.TMDB.repo.MovieRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieService {
	
	@Autowired
	private MovieRepository movierepository;
	
	//CRUD operations
	
	public Movie create(Movie movie) {
		if(movie==null) {
			throw new RuntimeException("Invalid movie");
		}
		return movierepository.save(movie);
	}
	
	public Movie read(Long id) {
		return movierepository.findById(id)
			.orElseThrow(() -> new RuntimeException("Movie not found"));
	}
	
	public Movie update(Long id, Movie update) {
		if(update==null || id==null) {
			throw new RuntimeException("Invalid movie");
		}
		//check if it exists
		if(movierepository.existsById(id)){
			Movie movie = movierepository.getReferenceById(id);
			movie.setName(update.getName());
			movie.setDirector(update.getDirector());
			movie.setActors(update.getActors());
			movierepository.save(movie);
			 return movierepository.save(movie);
		}
		else throw new RuntimeException("Movie not found");
	}
	
	public void delete(Long id) {
		if(movierepository.existsById(id)==false) {
			throw new RuntimeException("movie not found");
		}
		else  movierepository.deleteById(id);
	}
}



package com.gayathri.TMDB.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gayathri.TMDB.model.Movie;
import com.gayathri.TMDB.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/movies")
@Slf4j 
public class MovieController {
	
	@Autowired
	private MovieService movieservice;
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable Long id){
		Movie movie = movieservice.read(id);
		log.info("Returned movie with id: {}",id);
		return ResponseEntity.ok(movie);
	}
	
	@PostMapping
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
		Movie createdmovie = movieservice.create(movie);
		log.info("Created movie:", createdmovie.getId());
		return ResponseEntity.ok(createdmovie);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable Long id,@RequestBody Movie movie) {
		Movie updated = movieservice.update(id,movie);
		log.info("Updated movie:", id);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/{id}")
	public void deletemovie(@PathVariable Long id) {
		movieservice.delete(id);
		log.info("Deleted movie:", id);
	}
}

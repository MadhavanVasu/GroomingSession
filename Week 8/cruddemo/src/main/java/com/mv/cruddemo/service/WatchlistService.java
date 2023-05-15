package com.mv.cruddemo.service;

import com.mv.cruddemo.model.Movie;
import com.mv.cruddemo.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WatchlistService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
        log.info("Movie added to repository");
    }

}

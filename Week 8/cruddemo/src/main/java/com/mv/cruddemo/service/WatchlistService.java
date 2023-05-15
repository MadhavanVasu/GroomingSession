package com.mv.cruddemo.service;

import com.mv.cruddemo.dto.MovieDetailUpdateRequestDto;
import com.mv.cruddemo.exception.NoSuchMovieException;
import com.mv.cruddemo.model.Movie;
import com.mv.cruddemo.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

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

    public void updateMovieDetail(BigInteger movieId, MovieDetailUpdateRequestDto movieDetailDto) throws NoSuchMovieException {

        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {

            Movie updatedMovie = movie.get();
            if (movieDetailDto.getDirector() != null)
                updatedMovie.setDirector(movieDetailDto.getDirector());
            if (movieDetailDto.getDuration() != null)
                updatedMovie.setDuration(movieDetailDto.getDuration());
            if (movieDetailDto.getName() != null)
                updatedMovie.setName(movieDetailDto.getName());
            movieRepository.save(updatedMovie);
        } else throw new NoSuchMovieException("Invalid movie Id");
    }

    public void deleteMovie(BigInteger movieId) throws NoSuchMovieException {
        if (movieRepository.existsById(movieId))
            movieRepository.deleteById(movieId);
        else throw new NoSuchMovieException("Movie not found");
    }

}

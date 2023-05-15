package com.mv.cruddemo.controller;

import com.mv.cruddemo.dto.AddMovieRequestDto;
import com.mv.cruddemo.dto.MovieDetailUpdateRequestDto;
import com.mv.cruddemo.exception.NoSuchMovieException;
import com.mv.cruddemo.model.Movie;
import com.mv.cruddemo.service.WatchlistService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("watchlist")
@Slf4j
public class WatchlistController {

    @Autowired
    WatchlistService watchlistService;


    // GET
    @GetMapping("/getAll")
    public ResponseEntity<List<Movie>> getAllMoviesFromWatchlist() {
        return ResponseEntity.ok(watchlistService.getAllMovies());
    }

    // POST
    @PostMapping
    public ResponseEntity<String> addMovieToWatchlist(@RequestBody AddMovieRequestDto requestDto) {

        // Add converter for uppercase conversion of specific fields
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(AddMovieRequestDto.class, Movie.class)
                .addMapping(AddMovieRequestDto::getName, Movie::setName)
                .addMapping(AddMovieRequestDto::getGenre, Movie::setGenre)
                .addMapping(AddMovieRequestDto::getDirector, Movie::setDirector)
                .addMapping(AddMovieRequestDto::getDuration, Movie::setDuration)
                .addMapping(AddMovieRequestDto::getLanguage, Movie::setLanguage);
        Movie movie = modelMapper.map(requestDto, Movie.class);
        watchlistService.addMovie(movie);
        log.info("Request sent to service layer and movie added");
        return ResponseEntity.ok().body("Movie added");

    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMovieDetails(@PathVariable("id") BigInteger movieId, @RequestBody MovieDetailUpdateRequestDto updateDto) throws NoSuchMovieException {

        watchlistService.updateMovieDetail(movieId, updateDto);
        return ResponseEntity.ok().body("Update successful");

    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovieFromWatchlist(@PathVariable("id") BigInteger movieId) throws NoSuchMovieException {
        watchlistService.deleteMovie(movieId);
        return ResponseEntity.ok().body("Delete successful");
    }
}

package com.mv.cruddemo.controller;

import com.mv.cruddemo.dto.AddMovieRequestDto;
import com.mv.cruddemo.model.Movie;
import com.mv.cruddemo.service.WatchlistService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("watchlist")
@Slf4j
public class WatchlistController {

    @Autowired
    WatchlistService watchlistService;

    ModelMapper modelMapper = new ModelMapper();

    // GET
    @GetMapping("/getAll")
    public ResponseEntity<List<Movie>> getAllMoviesFromWatchlist() {
        return ResponseEntity.ok(watchlistService.getAllMovies());
    }

    // POST
    @PostMapping("/add")
    public ResponseEntity<String> addMovieToWatchlist(@RequestBody AddMovieRequestDto requestDto) {

        // Add converter for uppercase conversion of specific fields
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

    // DELETE

}

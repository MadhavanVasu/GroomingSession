package com.mv.cruddemo.advice;

import com.mv.cruddemo.exception.NoSuchMovieException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class WatchlistControllerAdvice {

    @ExceptionHandler(value = NoSuchMovieException.class)
    public ResponseEntity<String> handleMovieNotFound(NoSuchMovieException ex) {
        return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
    }

}

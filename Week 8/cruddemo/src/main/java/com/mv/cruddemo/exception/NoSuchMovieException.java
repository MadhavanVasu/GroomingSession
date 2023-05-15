package com.mv.cruddemo.exception;

public class NoSuchMovieException extends Exception {

    public NoSuchMovieException() {
        super();
    }

    public NoSuchMovieException(String message) {
        super(message);
    }

}

package com.mv.cruddemo.repository;

import com.mv.cruddemo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, BigInteger> {



}

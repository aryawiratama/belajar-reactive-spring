package com.arya.belajar.reactive.repository;

import com.arya.belajar.reactive.entity.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}

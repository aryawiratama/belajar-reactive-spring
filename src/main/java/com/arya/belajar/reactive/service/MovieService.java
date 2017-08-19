package com.arya.belajar.reactive.service;

import com.arya.belajar.reactive.entity.Movie;
import com.arya.belajar.reactive.entity.MovieEvent;
import com.arya.belajar.reactive.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Mono<Movie> findById(String movieId){
        return movieRepository.findById(movieId);
    }

    public Flux<Movie> findAllMovie(){
        return movieRepository.findAll();
    }

    public Flux<MovieEvent> movieSchedule (String movieId){
        Mono<Movie> movieMono = findById(movieId);
        return movieMono.flatMapMany(movie -> {
            Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
            Flux<MovieEvent> movieEventFlux = Flux.fromStream(
                    Stream.generate(() -> new MovieEvent(movie, new Date()))
            );
            Flux<Tuple2<Long, MovieEvent>> tuple2Flux = Flux.zip(interval, movieEventFlux);
            return tuple2Flux.map(Tuple2::getT2);
        });
    }
}

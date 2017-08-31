package com.arya.belajar.reactive.controller;

import com.arya.belajar.reactive.entity.Movie;
import com.arya.belajar.reactive.entity.MovieEvent;
import com.arya.belajar.reactive.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping({"/movies"})
public class MovieRestController {

    /*private MovieService movieService;

    @Autowired
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public Flux<Movie> findAllMovie(){
        return movieService.findAllMovie();
    }

    @GetMapping("/{movieId}")
    public Mono<Movie> findMovieById(@PathVariable("movieId") String movieId){
        return movieService.findById(movieId);
    }

    @GetMapping(path = "/{movieId}/schedules", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieEvent> schedules(@PathVariable("movieId")String movieId){
        return movieService.movieSchedule(movieId);
    }*/
}

package com.arya.belajar.reactive.handler;

import com.arya.belajar.reactive.entity.Movie;
import com.arya.belajar.reactive.entity.MovieEvent;
import com.arya.belajar.reactive.service.MovieService;
import com.mongodb.connection.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class MovieHandler {

    private MovieService movieService;

    @Autowired
    public MovieHandler(MovieService movieService) {
        this.movieService = movieService;
    }

    public Mono<ServerResponse> findAllMovie(ServerRequest serverRequest){
        return ServerResponse.ok().body(this.movieService.findAllMovie(), Movie.class);
    }

    public Mono<ServerResponse> findMovieById(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("movieId");
        return ServerResponse.ok().body(this.movieService.findById(id), Movie.class);
    }
    public Mono<ServerResponse> events(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("movieId");
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(this.movieService.movieSchedule(id), MovieEvent.class);
    }
}
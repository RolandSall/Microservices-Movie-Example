package com.rolandsalloum.movieinfoservice.Controller;

import com.rolandsalloum.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {


    @GetMapping("/{movieId}")
    public Movie getMovieInfoById(@PathVariable("movieId") String movieId){
       return new Movie(movieId, "Testing");

    }

}

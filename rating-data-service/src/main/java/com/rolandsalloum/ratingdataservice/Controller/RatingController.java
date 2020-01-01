package com.rolandsalloum.ratingdataservice.Controller;

import com.rolandsalloum.ratingdataservice.Model.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

    @GetMapping("/{movieId}")
    public Rating getRatingByMovieId(@PathVariable("movieId") String movieId){
        return  new Rating(movieId,5);
    }
}

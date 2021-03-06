package com.rolandsalloum.moviecatalogservice.Service.Rating;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rolandsalloum.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RatingService implements IRatingService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public ResponseEntity getUserRating(String userId) {
        return restTemplate.getForEntity("http://rating-data-service/ratingdata/users/" + userId, Rating[].class);
    }

    private ResponseEntity getFallbackUserRating(String userId) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Rating[] {Rating.builder().movieId("0").rating(0).build() });
    }

}

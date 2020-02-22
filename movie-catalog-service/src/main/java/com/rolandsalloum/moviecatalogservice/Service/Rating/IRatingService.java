package com.rolandsalloum.moviecatalogservice.Service.Rating;

import com.rolandsalloum.moviecatalogservice.model.Rating;
import org.springframework.http.ResponseEntity;

public interface IRatingService {

    ResponseEntity<Rating[]> getUserRating(String userId);
}

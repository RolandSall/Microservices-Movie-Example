package com.rolandsalloum.moviecatalogservice.Service.Movie;

import com.rolandsalloum.moviecatalogservice.model.Rating;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMovieService {


    ResponseEntity getCatalogItemForUser(List<Rating> ratingForUser);
}

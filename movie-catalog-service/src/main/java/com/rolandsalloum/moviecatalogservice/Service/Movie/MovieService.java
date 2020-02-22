package com.rolandsalloum.moviecatalogservice.Service.Movie;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rolandsalloum.moviecatalogservice.model.CatalogItem;
import com.rolandsalloum.moviecatalogservice.model.Movie;
import com.rolandsalloum.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCatalogFallback")
    public ResponseEntity getCatalogItemForUser(List<Rating> ratingForUser) {
        List<CatalogItem> catalogList = new ArrayList();
        for (Rating rating : ratingForUser) {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            catalogList.add(new CatalogItem(movie.getName(), "Desc", rating.getRating()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(catalogList);
    }

    private ResponseEntity getCatalogFallback(List<Rating> ratingForUser) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getFallBackCatalogResponse());
    }

    private List<CatalogItem> getFallBackCatalogResponse() {
        return Arrays.asList(CatalogItem.builder().name("Movie name not found").description("").rating(0).build());
    }
}

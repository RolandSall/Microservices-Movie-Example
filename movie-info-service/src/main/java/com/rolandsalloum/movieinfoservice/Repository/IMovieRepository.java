package com.rolandsalloum.movieinfoservice.Repository;

import com.rolandsalloum.movieinfoservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMovieRepository extends JpaRepository<Movie,Integer> {

    // Jpa repository know how to create the some simple querry for you
    Movie findBymovieId(String movie_id);
}

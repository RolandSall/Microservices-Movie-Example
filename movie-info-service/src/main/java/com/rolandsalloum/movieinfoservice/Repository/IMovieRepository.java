package com.rolandsalloum.movieinfoservice.Repository;

import com.rolandsalloum.movieinfoservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie,Integer> {
}

package com.rolandsalloum.ratingdataservice.Repository;

import com.rolandsalloum.ratingdataservice.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRatingRepositoryDAO extends JpaRepository<Rating, String> {

    List<Rating> findByUserId(String userId);



}

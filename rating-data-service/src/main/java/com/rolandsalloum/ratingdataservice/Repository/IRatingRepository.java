package com.rolandsalloum.ratingdataservice.Repository;

import com.rolandsalloum.ratingdataservice.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRatingRepository extends JpaRepository<Rating,String> {
}

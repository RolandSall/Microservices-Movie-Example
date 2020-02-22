package com.rolandsalloum.ratingdataservice.Model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String ratingId;
    @Column(updatable = false, nullable = false)
    private String userId;
    @Column(updatable = false, nullable = false)
    private String movieId;
    @Column(updatable = false, nullable = false)
    private double rating;
}

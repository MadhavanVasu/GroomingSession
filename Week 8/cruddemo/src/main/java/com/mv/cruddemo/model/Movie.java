package com.mv.cruddemo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    // The @SequenceGenerator annotation is used to define a sequence object that generates unique sequence
    // values, which can be used as primary key values for entities.
    // It allows you to define the sequence name, the initial value, the increment size, and other parameters.

    // The @GeneratedValue annotation is used to specify the strategy for generating primary key values
    // for an entity.
    // It takes a strategy parameter that defines the generation strategy.
    // The possible values for the strategy parameter are AUTO, IDENTITY, SEQUENCE, and TABLE.
    // When you set the strategy parameter to IDENTITY, the database generates a unique value for each
    // inserted row.
    // When you set it to SEQUENCE, the entity manager obtains the next value of the sequence defined
    // by the @SequenceGenerator annotation.
    @Id
    @SequenceGenerator(name = "my_sequence", sequenceName = "my_custom_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
    private BigInteger movieId;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    private Integer duration;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private Language language;

    private String director;


}

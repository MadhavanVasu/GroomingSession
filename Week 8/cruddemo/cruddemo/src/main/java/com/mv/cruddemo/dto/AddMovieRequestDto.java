package com.mv.cruddemo.dto;

import com.mv.cruddemo.model.Genre;
import com.mv.cruddemo.model.Language;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class AddMovieRequestDto {

    private String name;

    private String genre;

    private Integer duration;

    private String language;

    private String director;

}

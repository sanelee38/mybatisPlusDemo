package com.sanelee.mybatisplus.generator.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author sanelee
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer movieId;

    private String movieTitle;

    private String movieIntroduction;

    private Float movieRating;

    private String movieReleaseDate;


}

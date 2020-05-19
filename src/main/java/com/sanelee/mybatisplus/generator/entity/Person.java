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
public class Person implements Serializable {

    private static final long serialVersionUID=1L;

      private Integer personId;

    private String personBirthDay;

    private String personDeathDay;

    private String personName;

    private String personEnglishName;

    private String personBiography;

    private String personBirthPlace;


}

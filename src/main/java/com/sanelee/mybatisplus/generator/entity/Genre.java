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
public class Genre implements Serializable {

    private static final long serialVersionUID=1L;

      private Integer genreId;

    private String genreName;


}

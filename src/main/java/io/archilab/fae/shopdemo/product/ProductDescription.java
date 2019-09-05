package io.archilab.fae.shopdemo.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDescription {

  private static final int MAX_LENGTH = 3000;

  @Column(length = 3000)
  private String description;

  public ProductDescription(String description) {
    if (!ProductDescription.isValid(description)) {
      throw new IllegalArgumentException(
          String.format("Name %s exceeded maximum number of %d allowed characters", description,
              ProductDescription.MAX_LENGTH));
    }
    this.description = description;
  }

  public static boolean isValid(String name) {
    return name != null && name.length() <= ProductDescription.MAX_LENGTH;
  }
}

package io.archilab.fae.shopdemo.product;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductName {

  private static final int MAX_LENGTH = 255;

  private String name;

  public ProductName(String name) {
    if (!ProductName.isValid(name)) {
      throw new IllegalArgumentException(
          String.format("Name %s exceeded maximum number of %d allowed characters", name,
              ProductName.MAX_LENGTH));
    }
    this.name = name;
  }

  public static boolean isValid(String name) {
    return name != null && name.length() <= ProductName.MAX_LENGTH;
  }
}

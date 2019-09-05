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
public class ProductPrice {

  private int price;


  public ProductPrice(int price) {
    this.price = price;
  }
}

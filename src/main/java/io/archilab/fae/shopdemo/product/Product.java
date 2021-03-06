package io.archilab.fae.shopdemo.product;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.archilab.fae.shopdemo.core.AbstractEntity;
import io.archilab.fae.shopdemo.product.events.ProductEventHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@EntityListeners(ProductEventHandler.class)
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product extends AbstractEntity {

  @Setter
  @JsonUnwrapped
  private ProductName name;

  @Setter
  @JsonUnwrapped
  private ProductDescription description;

  @Setter
  @JsonUnwrapped
  private ProductPrice price;
}

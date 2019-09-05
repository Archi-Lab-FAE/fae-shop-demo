package io.archilab.fae.shopdemo.order;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.archilab.fae.shopdemo.core.AbstractEntity;
import io.archilab.fae.shopdemo.product.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "order_table") // Unfortunately "Order" is a service word in SQL
public class Order extends AbstractEntity {

  @Setter
  @JsonUnwrapped
  private OrderName name;

  @ManyToMany
  private Set<Product> products;
}

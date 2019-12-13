package io.archilab.fae.shopdemo.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID>, ProductRepositoryCustom {
  Set<Product> findByPrice_Price(@Param(value = "price") int price);
}

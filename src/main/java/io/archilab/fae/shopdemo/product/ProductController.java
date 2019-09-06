package io.archilab.fae.shopdemo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping("/shop-demo/level-2/products")
  public Iterable<Product> products() {
    return productRepository.findAll();
  }

  @PostMapping("/shop-demo/level-2/products")
  public Product newProduct(@RequestBody Product newProduct) {
    return productRepository.save(newProduct);
  }

  @DeleteMapping("/shop-demo/level-2/products/{id}")
  public void deleteProduct(@PathVariable UUID id) {
    productRepository.deleteById(id);
  }
}

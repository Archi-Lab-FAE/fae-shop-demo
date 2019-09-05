package io.archilab.fae.shopdemo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.databind.util.ArrayIterator;

import io.archilab.fae.shopdemo.product.Product;

@RestController
public class OrderController {

  @Autowired
  private OrderRepository orderRepository;

  @GetMapping("/level-2/orders")
  public Iterable<Order> orders() {
    return orderRepository.findAll();
  }

  @GetMapping("/level-2/orders/{id}/products")
  public Iterable<Product> orderProducts(@PathVariable UUID id) {
    Optional<Order> order = orderRepository.findById(id);
    if (order.isPresent()) {
      return order.get().getProducts();
    } else {
      return new ArrayList<>();
    }
  }

  @PostMapping("/level-2/orders")
  public Order newOrder(@RequestBody Order newOrder) {
    return orderRepository.save(newOrder);
  }

  @DeleteMapping("/level-2/orders/{id}")
  public void deleteOrder(@PathVariable UUID id) {
    orderRepository.deleteById(id);
  }
}

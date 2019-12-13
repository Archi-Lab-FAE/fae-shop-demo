package io.archilab.fae.shopdemo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RepositoryRestController
@ExposesResourceFor(Product.class)
@RequestMapping("products")
public class ProductController3 {

  private static final Random r = new Random();

  @Autowired
  private ProductRepository productRepository;

  @RequestMapping(path = "productRecommendations", method = RequestMethod.GET, produces = {"application/hal+json"})
  public ResponseEntity<Resources<Resource<Product>>> productRecommendations() {
    List<Product> recommendedProducts = new ArrayList<>();

    for (Product product : productRepository.findAll()) {
     if (r.nextBoolean()) {
       recommendedProducts.add(product);
     }
    }

    Resources<Resource<Product>> recommendedTagResources = generateProductResources(
        recommendedProducts);

    recommendedTagResources.add(ControllerLinkBuilder.linkTo(
        ControllerLinkBuilder.methodOn(ProductController3.class).productRecommendations())
        .withSelfRel());

    return ResponseEntity.ok(recommendedTagResources);
  }

  private Resource<Product> generateProductResource(Product product) {
    Resource<Product> productResource = new Resource<>(product);
    productResource
        .add(ControllerLinkBuilder.linkTo(ProductController3.class).slash(product.getId()).withSelfRel());
    productResource
        .add(ControllerLinkBuilder.linkTo(ProductController3.class).slash(product.getId()).withRel("product"));
    return productResource;
  }

  private Resources<Resource<Product>> generateProductResources(Iterable<Product> products) {
    List<Resource<Product>> productResourceList = new ArrayList<>();
    for (Product product : products) {
      productResourceList.add(generateProductResource(product));
    }

    return new Resources<Resource<Product>>(productResourceList);
  }
}

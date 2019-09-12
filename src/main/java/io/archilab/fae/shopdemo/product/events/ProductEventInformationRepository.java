package io.archilab.fae.shopdemo.product.events;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface ProductEventInformationRepository extends CrudRepository<ProductEventInformation, UUID> {

}

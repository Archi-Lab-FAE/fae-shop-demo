package io.archilab.fae.shopdemo.product.events;


import java.util.UUID;

import io.archilab.fae.shopdemo.core.DomainEvent;

public class ProductDomainEvent extends DomainEvent {

  private final UUID productIdentifier;
  private final ProductEventType eventType;

  protected ProductDomainEvent() {
    this.productIdentifier = null;
    this.eventType = null;
  }

  public ProductDomainEvent(UUID productIdentifier,
      ProductEventType eventType) {
    this.productIdentifier = productIdentifier;
    this.eventType = eventType;
  }

  @Override
  public String getEventType() {
    return this.eventType.name();
  }

  public UUID getProductIdentifier() {
    return productIdentifier;
  }
}

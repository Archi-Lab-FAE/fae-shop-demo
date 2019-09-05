package io.archilab.fae.shopdemo.core;

import java.util.UUID;

public abstract class DomainEvent {

  private final UUID eventID;

  public DomainEvent() {
    this.eventID = UUID.randomUUID();
  }

  public abstract String getEventType();

  public UUID getEventID() {
    return this.eventID;
  }
}

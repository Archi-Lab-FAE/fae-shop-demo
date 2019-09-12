package io.archilab.fae.shopdemo.product.events;

import java.util.Date;

import javax.persistence.Entity;

import io.archilab.fae.shopdemo.core.AbstractEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProductEventInformation extends AbstractEntity {

  private String productEventType;
  private Date date;
}

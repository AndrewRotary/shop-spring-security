package com.shop.Model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 3/27/2017.
 */
@Entity
public class Immage implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  private String path;

  @ManyToOne
  @JoinColumn(name = "item_id")
  private Item item;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
}

package com.shop.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by student on 3/27/2017.
 */
@Entity
public class Category implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @OneToMany(mappedBy = "category")
  Collection<Item> items;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Collection<Item> getItems() {
    return items;
  }

  public void setItems(Collection<Item> items) {
    this.items = items;
  }
}

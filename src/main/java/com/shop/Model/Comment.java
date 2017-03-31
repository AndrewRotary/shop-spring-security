package com.shop.Model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 3/27/2017.
 */
@Entity
public class Comment implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  private String text;

  @ManyToOne
  @JoinColumn(name = "item_id")
  private Item item;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}

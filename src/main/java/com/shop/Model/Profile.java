package com.shop.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by student on 3/27/2017.
 */
@Entity
public class Profile implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @OneToMany(mappedBy = "profile")
  private Collection<User> users;

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

  public Collection<User> getUsers() {
    return users;
  }

  public void setUsers(Collection<User> users) {
    this.users = users;
  }
}

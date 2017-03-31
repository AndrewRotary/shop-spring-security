package com.shop.Model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.util.Collection;
import java.util.List;

/**
 * Created by student on 3/27/2017.
 */
@Entity
public class Item implements Serializable{

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String description;

  @OneToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Collection<Immage> immages;

  @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
  private Collection<Comment> comments;

  @Transient
  private List<MultipartFile> imageMultipart;

  private Double price;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Collection<Immage> getImmages() {
    return immages;
  }

  public void setImmages(Collection<Immage> immages) {
    this.immages = immages;
  }

  public Collection<Comment> getComments() {
    return comments;
  }

  public void setComments(Collection<Comment> comments) {
    this.comments = comments;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<MultipartFile> getImageMultipart() {
    return imageMultipart;
  }

  public void setImageMultipart(List<MultipartFile> imageMultipart) {
    this.imageMultipart = imageMultipart;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}

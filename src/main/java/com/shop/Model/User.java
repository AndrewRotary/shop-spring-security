package com.shop.Model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by student on 3/27/2017.
 */
@Entity
@Table(name = "person")
public class User implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String password;

  @Transient
  private MultipartFile imageMultipart;

  @OneToOne
  @JoinColumn(name = "profile_id")
  private Profile profile;

  @OneToMany(mappedBy = "user")
  private Collection<Comment> comments;

  private String path;

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

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public Collection<Comment> getComments() {
    return comments;
  }

  public void setComments(Collection<Comment> comments) {
    this.comments = comments;
  }

  public MultipartFile getImageMultipart() {
    return imageMultipart;
  }

  public void setImageMultipart(MultipartFile imageMultipart) {
    this.imageMultipart = imageMultipart;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}

package com.company.inventory.inventory.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // import lombok dependencies en pom.xml
@Entity
@Table(name="category")
public class Category implements Serializable {
  
  private static final long serialVersionUID = -4520194628683973939L;

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;
  private String name;
  private String description;


}

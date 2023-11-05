package com.company.inventory.inventory.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data 
@Entity
@Table( name="product")
public class Product implements Serializable {
  
  private static final long serialVersionUID = -431001722775244681L;

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;
  private String name;
  private int price;
  private int account;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnoreProperties( {"hibernateLazyInitializer", "handler"})
  private Category category;

  //@Lob
  //@Basic( fetch = FetchType.LAZY) // @Lob and @Basic to increase image storage size
  @Column(name ="picture", length = 4194303 )
  private byte[] picture;

}

package com.company.inventory.inventory.services;

import org.springframework.http.ResponseEntity;

import com.company.inventory.inventory.model.Product;
import com.company.inventory.inventory.response.ProductResponseRest;

public interface IproductService {

  public ResponseEntity<ProductResponseRest> createProduct( Product product, long categoryId);
  
}

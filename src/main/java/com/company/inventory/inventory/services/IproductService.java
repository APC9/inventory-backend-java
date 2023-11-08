package com.company.inventory.inventory.services;

import org.springframework.http.ResponseEntity;

import com.company.inventory.inventory.model.Product;
import com.company.inventory.inventory.response.ProductResponseRest;

public interface IproductService {

  
  public ResponseEntity<ProductResponseRest> search();
  public ResponseEntity<ProductResponseRest> searchById(long Id);
  public ResponseEntity<ProductResponseRest> deleteById(long Id);
  public ResponseEntity<ProductResponseRest> searchByName(String name);
  public ResponseEntity<ProductResponseRest> createProduct( Product product, long Id);
  public ResponseEntity<ProductResponseRest> updateProduct( Product product, long categoryId, long Id);
}

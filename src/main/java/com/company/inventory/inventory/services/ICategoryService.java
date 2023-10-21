package com.company.inventory.inventory.services;

import org.springframework.http.ResponseEntity;

import com.company.inventory.inventory.respose.CategoryResponseRest;

public interface ICategoryService {
  
  public ResponseEntity<CategoryResponseRest> search();
}

package com.company.inventory.inventory.services;

import org.springframework.http.ResponseEntity;

import com.company.inventory.inventory.model.Category;
import com.company.inventory.inventory.response.CategoryResponseRest;

public interface ICategoryService {
  
  public ResponseEntity<CategoryResponseRest> search();
  public ResponseEntity<CategoryResponseRest> searchById( Long id );
  public ResponseEntity<CategoryResponseRest> deleteById( Long id );
  public ResponseEntity<CategoryResponseRest> createCategory( Category category );
  public ResponseEntity<CategoryResponseRest> updateCategory( Category category, Long id );

}

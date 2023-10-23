package com.company.inventory.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.inventory.respose.CategoryResponseRest;
import com.company.inventory.inventory.services.ICategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

  @Autowired
  private ICategoryService service;

  /**
   * get all categories
   * @return
   */
  @GetMapping("/categories")
  public ResponseEntity<CategoryResponseRest> sarchCategory(){
    ResponseEntity<CategoryResponseRest> response = service.search();
    return response;
  }

  /**
   * get categories by id
   * @param id 
   * @return
   */
  @GetMapping("/categories/{id}")
  public ResponseEntity<CategoryResponseRest> sarchCategoryById( @PathVariable Long id ){
    ResponseEntity<CategoryResponseRest> response = service.searchById(id);
    return response;
  }

}

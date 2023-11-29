package com.company.inventory.inventory.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.inventory.model.Category;
import com.company.inventory.inventory.response.CategoryResponseRest;
import com.company.inventory.inventory.services.ICategoryService;
import com.company.inventory.inventory.util.CategoryExcelExport;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin( origins = "*" ) //  "*": cualquier URL  --  { "http://localhost:4200"}: una URl especifica 
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


  /**
   * Create a new category
   * @param category
   * @return
   */
  @PostMapping("/categories")
  public ResponseEntity<CategoryResponseRest> createCategory( @RequestBody Category category){
    ResponseEntity<CategoryResponseRest> response = service.createCategory(category);
    return response;
  }

  /**
   * Update a category
   * @param category Category
   * @param id Long
   * @return
    */
  @PutMapping("/categories/{id}")
  public ResponseEntity<CategoryResponseRest> updateCategory( @RequestBody Category category, @PathVariable Long id){
    ResponseEntity<CategoryResponseRest> response = service.updateCategory(category, id);
    return response;
  }

  /**
   * Delete a category
   * @param id
   * @return
    */
  @DeleteMapping("/categories/{id}")
  public ResponseEntity<CategoryResponseRest> deleteCategory( @PathVariable Long id){
    ResponseEntity<CategoryResponseRest> response = service.deleteById( id);
    return response;
  }

  @GetMapping("/categories/export/excel")
  public void exportToExcel( HttpServletResponse response ) throws IOException{
    response.setContentType("application/octet-stream");

    String headerKey = "conntent-Disposition";
    String headerValue = "attachment; filename=result_category.xlsx";
    
    response.setHeader(headerKey, headerValue);

    ResponseEntity<CategoryResponseRest> categoryResponse = service.search();

    CategoryExcelExport excelExporter = new CategoryExcelExport( categoryResponse.getBody().getCategoryResponse().getCategory() );

    excelExporter.export(response);
  } 


}

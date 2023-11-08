package com.company.inventory.inventory.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.company.inventory.inventory.model.Product;
import com.company.inventory.inventory.response.ProductResponseRest;
import com.company.inventory.inventory.services.IproductService;
import com.company.inventory.inventory.util.Util;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping("/api/v1")
public class productRestController {

  private IproductService productService;

  public productRestController( IproductService productService ) {
    super();
    this.productService = productService;
  }


  /**
   * Create a new product
   * @param picture
   * @param name
   * @param price
   * @param account
   * @param categoryId
   * @return
   * @throws IOException
   */
  @PostMapping("/products")
  public ResponseEntity<ProductResponseRest> createProduct(
    @RequestParam("picture") MultipartFile picture,
    @RequestParam("name") String name,
    @RequestParam("price") int price,
    @RequestParam("account") int account,
    @RequestParam("categoryId") Long categoryId) throws IOException{
    
      Product product = new Product();
      product.setName(name);
      product.setPrice(price);
      product.setAccount(account);
      product.setPicture(Util.compressZLib(picture.getBytes()));

      ResponseEntity<ProductResponseRest> response = productService.createProduct( product, categoryId );
      return response;
  }  

  /**
   * Search products by id
   * @param id
   * @return
    */
  @GetMapping("/products/{id}")
  public ResponseEntity<ProductResponseRest> searchById( @PathVariable Long id){
    ResponseEntity<ProductResponseRest> response = productService.searchById(id);
    return response;
  }

  /**
   * Search products by id
   * @param id
   * @return
    */
  @DeleteMapping("/products/{id}")
  public ResponseEntity<ProductResponseRest> deleteById( @PathVariable Long id){
    ResponseEntity<ProductResponseRest> response = productService.deleteById(id);
    return response;
  }

  /**
   * Get products by name 
   * @param name
   * @return
    */
  @GetMapping("/products/filter/{name}")
  public ResponseEntity<ProductResponseRest> searchByName( @PathVariable String name){
    ResponseEntity<ProductResponseRest> response = productService.searchByName(name);
    return response;
  }

  /**
   * Get all products
   * @return
    */
  @GetMapping("/products")
  public ResponseEntity<ProductResponseRest> search(){
    ResponseEntity<ProductResponseRest> response = productService.search();
    return response; 
  }

}

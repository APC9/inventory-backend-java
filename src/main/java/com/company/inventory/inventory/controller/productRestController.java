package com.company.inventory.inventory.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
   * 
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
}

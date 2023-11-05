package com.company.inventory.inventory.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.inventory.inventory.dao.ICategoryDao;
import com.company.inventory.inventory.dao.IProductDao;
import com.company.inventory.inventory.model.Category;
import com.company.inventory.inventory.model.Product;
import com.company.inventory.inventory.response.ProductResponseRest;
import com.company.inventory.inventory.util.Util;


@Service
public class ProductServiceImpl implements IproductService{

  // dependency injections with the constructor
  private ICategoryDao categoryDao;
  private IProductDao productDao;

  // constructor
  public ProductServiceImpl( ICategoryDao categoryDao, IProductDao productDao ){
    super(); 
    this.categoryDao = categoryDao;
    this.productDao = productDao;
  }

  @Override
  @Transactional
  public ResponseEntity<ProductResponseRest> createProduct(Product product, long categoryId) {
   
    ProductResponseRest response = new ProductResponseRest();
    List<Product> list = new ArrayList<>();

    try {
     
      //search Category to set in the product object
      Optional<Category> category = categoryDao.findById(categoryId);
      
      if( !category.isPresent() ){
        response.setMetadata("Respuesta nok", "-1", "Categoy not found");
        return new ResponseEntity<ProductResponseRest>( response, HttpStatus.NOT_FOUND);
      }

      // get category
      product.setCategory( category.get() );

      // save product
      Product productSaved = productDao.save(product);

      if ( productSaved == null ) {
        response.setMetadata("Respuesta nok", "-1", "product not saved");
        return new ResponseEntity<ProductResponseRest>( response, HttpStatus.BAD_REQUEST);
      }

      list.add(productSaved);
      response.getProductResponse().setProducts(list);
      response.setMetadata("Respuesta ok", "00", "Product saved successfully");
  
    } catch (Exception e) {
        e.getStackTrace();
        response.setMetadata("Respuesta nok", "-1", "Error saved product, check logs");
        return new ResponseEntity<ProductResponseRest>( response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<ProductResponseRest>( response, HttpStatus.OK);
  }

  @Override
  @Transactional( readOnly = true)
  public ResponseEntity<ProductResponseRest> searchById(long categoryId) {
    ProductResponseRest response = new ProductResponseRest();
    List<Product> list = new ArrayList<>();

    try {
      // search by product by id
      Optional<Product> product = productDao.findById(categoryId);

      if(!product.isPresent()) {
        response.setMetadata("Respuesta nok", "-1", "product not found");
        return new ResponseEntity<ProductResponseRest>( response, HttpStatus.NOT_FOUND);
      }

      byte[] imageDescompressed = Util.decompressZLib( product.get().getPicture() );
      product.get().setPicture(imageDescompressed);
      list.add(product.get());
      response.getProductResponse().setProducts(list);
      response.setMetadata("Respuesta ok", "00", "Product found successfully");

    } catch (Exception e) {
        e.getStackTrace();
        response.setMetadata("Respuesta nok", "-1", "Error saved product, check logs");
        return new ResponseEntity<ProductResponseRest>( response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<ProductResponseRest>( response, HttpStatus.OK);    
  }

  @Override
  @Transactional( readOnly = true)
  public ResponseEntity<ProductResponseRest> search() {
    ProductResponseRest response = new ProductResponseRest();
    List<Product> products = (List<Product>) productDao.findAll();

    try {
      response.getProductResponse().setProducts(products);
      response.setMetadata("respuesta nok", "00", "response successfully");

    } catch (Exception e) {
      e.getStackTrace();
      response.setMetadata("Respuesta nok", "-1", "Error al Consultar");
      return new ResponseEntity<ProductResponseRest>( response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<ProductResponseRest>( response, HttpStatus.OK);
  }
  
}

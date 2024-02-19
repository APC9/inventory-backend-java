package com.company.inventory.inventory.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.company.inventory.inventory.model.Product;
import java.util.List;


public interface IProductDao extends CrudRepository<Product, Long>{

  /* Se pudede hacer un metodo de busqueda de 2 formas */
  // forma 1: hacer la Query manual
  @Query("SELECT p from Product p where p.name like %?1%")
  List<Product> findByName(String name);

  // forma 2: nombre en el metodo ej: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
  List<Product> findByNameContainingIgnoreCase(String name);
  
}

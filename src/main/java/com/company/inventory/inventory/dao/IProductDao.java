package com.company.inventory.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.inventory.inventory.model.Product;

public interface IProductDao extends CrudRepository<Product, Long>{
  
}

package com.company.inventory.inventory.response;

import java.util.List;

import com.company.inventory.inventory.model.Product;

import lombok.Data;

@Data
public class ProductResponse {
  
  List<Product> products;
}

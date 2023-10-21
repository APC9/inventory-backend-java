package com.company.inventory.inventory.respose;

import java.util.List;
import com.company.inventory.inventory.model.Category;

import lombok.Data;

@Data
public class CategoryResponse {
  private List<Category> category;
}

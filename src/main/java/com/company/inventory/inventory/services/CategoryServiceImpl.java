package com.company.inventory.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.inventory.inventory.dao.ICategoryDao;
import com.company.inventory.inventory.model.Category;
import com.company.inventory.inventory.respose.CategoryResponseRest;


@Service
public class CategoryServiceImpl implements ICategoryService {

  @Autowired
  private ICategoryDao categoryDao;

  @Override
  @Transactional( readOnly = true)
  public ResponseEntity<CategoryResponseRest> search() {
    CategoryResponseRest response = new CategoryResponseRest();

    try {
      List<Category> Category = (List<Category>) categoryDao.findAll();
      response.getCategoryResponse().setCategory(Category);
      response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
    } catch (Exception e) {
      response.setMetadata("Respuesta nok", "-1", "Error al Consultar");
      e.getStackTrace();
      return new ResponseEntity<CategoryResponseRest>( response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<CategoryResponseRest>( response, HttpStatus.OK);
  }
  

}
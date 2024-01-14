package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.*;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

}

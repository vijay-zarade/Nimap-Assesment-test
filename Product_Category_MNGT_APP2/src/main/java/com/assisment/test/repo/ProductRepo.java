package com.assisment.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assisment.test.entities.ProductEntities;

public interface ProductRepo extends JpaRepository<ProductEntities, Integer> {

}

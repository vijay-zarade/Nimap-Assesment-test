package com.assisment.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assisment.test.entities.CategoryEntities;

public interface CategoryRepo extends JpaRepository<CategoryEntities, Integer> {

}

package com.assisment.test.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "category")
@Data
public class CategoryEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer category_Id;

	private String category_Name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<ProductEntities> products;

}

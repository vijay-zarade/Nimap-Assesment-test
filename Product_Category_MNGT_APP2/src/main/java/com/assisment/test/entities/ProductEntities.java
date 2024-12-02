package com.assisment.test.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ProductEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_Id;
	
	private String product_Name;
	
	private Integer price;
	
	@ManyToOne
	private CategoryEntities category;

}

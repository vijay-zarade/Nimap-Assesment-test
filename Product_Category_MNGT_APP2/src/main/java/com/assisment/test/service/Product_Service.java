package com.assisment.test.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.assisment.test.dto.Product_Dto;
import com.assisment.test.entities.CategoryEntities;
import com.assisment.test.entities.ProductEntities;
import com.assisment.test.exception.ResourceNotFoundExceptionHandle;
import com.assisment.test.repo.CategoryRepo;
import com.assisment.test.repo.ProductRepo;

@Service
public class Product_Service {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ModelMapper modelMapper;

	public Product_Dto createProduct(Product_Dto product_Dto, Integer category_Id) {

		CategoryEntities category = categoryRepo.findById(category_Id)
				.orElseThrow(() -> new ResourceNotFoundExceptionHandle("Category", "category_Id", category_Id));

		ProductEntities product = modelMapper.map(product_Dto, ProductEntities.class);
		product.setCategory(category);
		ProductEntities product2 = this.productRepo.save(product);

		
		return this.modelMapper.map(product2, Product_Dto.class);

	}

	public Product_Dto updateProduct(Integer product_Id, Product_Dto product_Dto) {

		ProductEntities product = this.productRepo.findById(product_Id)
				.orElseThrow(() -> new ResourceNotFoundExceptionHandle("product", "product_Id", product_Id));

		product.setProduct_Name(product_Dto.getProduct_Name());
		product.setPrice(product_Dto.getPrice());

		return this.modelMapper.map(product, Product_Dto.class);
	}

	public Product_Dto getProductById(Integer product_Id) {

		ProductEntities product = this.productRepo.findById(product_Id)
				.orElseThrow(() -> new ResourceNotFoundExceptionHandle("product", "product_Id", product_Id));

		return this.modelMapper.map(product, Product_Dto.class);

	}

	public List<Product_Dto> getProducts(Integer pageNumber, Integer pageSize) {

		Pageable pageable = PageRequest.of(pageNumber, pageSize);

		Page<ProductEntities> pagePost = this.productRepo.findAll(pageable);

		List<ProductEntities> product = pagePost.getContent();

		return product.stream().map((p) -> this.modelMapper.map(p, Product_Dto.class)).collect(Collectors.toList());
	}

	public String deleteProductById(Integer product_Id) {
		ProductEntities product = this.productRepo.findById(product_Id)
				.orElseThrow(() -> new ResourceNotFoundExceptionHandle("product", "product_Id", product_Id));

		this.productRepo.delete(product);
		return "product is deleted";
	}

}

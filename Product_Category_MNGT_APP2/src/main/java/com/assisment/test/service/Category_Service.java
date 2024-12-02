package com.assisment.test.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assisment.test.dto.Category_Dto;
import com.assisment.test.entities.CategoryEntities;
import com.assisment.test.exception.ResourceNotFoundExceptionHandle;
import com.assisment.test.repo.CategoryRepo;

@Service
public class Category_Service {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	public Category_Dto createCategory(Category_Dto category_Dto) {

		CategoryEntities category = modelMapper.map(category_Dto, CategoryEntities.class);
		CategoryEntities save = categoryRepo.save(category);

		return this.modelMapper.map(save, Category_Dto.class);

	}

	public Category_Dto updateCategory(Integer category_Id, Category_Dto categoryDto) {

		CategoryEntities category = this.categoryRepo.findById(category_Id)
				.orElseThrow(() -> new ResourceNotFoundExceptionHandle("category", "category_Id", category_Id));

		category.setCategory_Name(categoryDto.getCategory_Name());

		CategoryEntities category2 = this.categoryRepo.save(category);

		return this.modelMapper.map(category2, Category_Dto.class);
	}

	public Category_Dto getCategoryById(Integer category_Id) {

		CategoryEntities category = this.categoryRepo.findById(category_Id)
				.orElseThrow(() -> new ResourceNotFoundExceptionHandle("category", "categoryId", category_Id));

		return this.modelMapper.map(category, Category_Dto.class);

	}

	public List<Category_Dto> getCategories() {
		List<CategoryEntities> all = this.categoryRepo.findAll();

		return all.stream().map((cat) -> this.modelMapper.map(cat, Category_Dto.class)).collect(Collectors.toList());
	}
	
	public String deleteCategoryById(Integer category_Id)
	{
		CategoryEntities category = this.categoryRepo.findById(category_Id)
				.orElseThrow(() -> new ResourceNotFoundExceptionHandle("category", "categoryId", category_Id));
		
		this.categoryRepo.delete(category);
		
		return "category is deleted";
	}
}

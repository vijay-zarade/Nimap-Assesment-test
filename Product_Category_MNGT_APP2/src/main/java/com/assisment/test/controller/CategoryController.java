package com.assisment.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assisment.test.dto.Category_Dto;
import com.assisment.test.response.ApiResponse;
import com.assisment.test.service.Category_Service;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private Category_Service categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@RequestBody Category_Dto category_Dto) {
		Category_Dto category = this.categoryService.createCategory(category_Dto);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(category);
		apiResponse.setMessage("category is created");
		apiResponse.setStatus(true);
		apiResponse.setError(false);
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{category_Id}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable	Integer category_Id,@RequestBody Category_Dto category_Dto) {
		
		Category_Dto updateCategory = this.categoryService.updateCategory(category_Id, category_Dto);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(updateCategory);
		apiResponse.setMessage("category is updated");
		apiResponse.setStatus(true);
		apiResponse.setError(false);
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
	
	@GetMapping("/category/{category_Id}")
	public ResponseEntity<ApiResponse> getByIdCategory(@PathVariable Integer category_Id) {
		
		Category_Dto categoryById = this.categoryService.getCategoryById(category_Id);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(categoryById);
		apiResponse.setMessage("single category data is fetch");
		apiResponse.setStatus(true);
		apiResponse.setError(false);
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<ApiResponse> getAllCategory() {
		
		List<Category_Dto> categories = this.categoryService.getCategories();
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(categories);
		apiResponse.setMessage("all category data is fetch");
		apiResponse.setStatus(true);
		apiResponse.setError(false);
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{category_Id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer category_Id) {
		
		String deleteCategoryById = this.categoryService.deleteCategoryById(category_Id);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(deleteCategoryById);
		apiResponse.setMessage("category data is deleted");
		apiResponse.setStatus(true);
		apiResponse.setError(false);
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
	
	

}

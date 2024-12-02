package com.assisment.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assisment.test.dto.Product_Dto;
import com.assisment.test.response.ApiResponse;
import com.assisment.test.service.Product_Service;

@RestController
@RequestMapping("api")
public class ProductController {

	@Autowired
	private Product_Service productService;

	@PostMapping("/category/{category_Id}/product")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody Product_Dto product_Dto,
			@PathVariable Integer category_Id) {
		Product_Dto product = this.productService.createProduct(product_Dto, category_Id);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(product);
		apiResponse.setMessage("product created succesfully!!!");
		apiResponse.setStatus(true);
		apiResponse.setError(false);

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
	}

	@GetMapping("/update/{product_Id}")
	public ResponseEntity<ApiResponse> updateProduct(@RequestBody Product_Dto product_Dto,
			@PathVariable Integer productId) {
		Product_Dto updateProduct = this.productService.updateProduct(productId, product_Dto);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(updateProduct);
		apiResponse.setMessage("product update succesfully!!!");
		apiResponse.setStatus(true);
		apiResponse.setError(false);

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/get/{product_Id}")
	public ResponseEntity<ApiResponse> getProduct(@PathVariable Integer product_Id) {

		Product_Dto productById = this.productService.getProductById(product_Id);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(productById);
		apiResponse.setMessage("product get succesfully!!!");
		apiResponse.setStatus(true);
		apiResponse.setError(false);

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/products")
	public ResponseEntity<ApiResponse> getProducts(@RequestParam(value = "pageNumber") Integer pageNumber,
			@RequestParam(value = "pageSize") Integer pageSize) {

		List<Product_Dto> products = this.productService.getProducts(pageNumber, pageSize);

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(products);
		apiResponse.setMessage("product get succesfully!!!");
		apiResponse.setStatus(true);
		apiResponse.setError(false);

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	@DeleteMapping("/product/{product_Id}")
	public ResponseEntity<ApiResponse> deleteProducts(@PathVariable Integer product_Id) {

		String deleteProductById = this.productService.deleteProductById(product_Id);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setData(deleteProductById);
		apiResponse.setMessage("product delete succesfully!!!");
		apiResponse.setStatus(true);
		apiResponse.setError(false);

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

}

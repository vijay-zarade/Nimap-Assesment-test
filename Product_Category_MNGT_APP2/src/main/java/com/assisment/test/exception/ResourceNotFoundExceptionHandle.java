package com.assisment.test.exception;

import lombok.Data;

@Data
public class ResourceNotFoundExceptionHandle extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourceName;
	private String fieldName;
	private Integer fieldValue;

	public ResourceNotFoundExceptionHandle(String resourceName, String fieldName, Integer fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}

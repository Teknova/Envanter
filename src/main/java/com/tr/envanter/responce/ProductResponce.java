package com.tr.envanter.responce;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProductResponce<T> extends ResponseEntity<T> {

	public ProductResponce(T body, HttpStatus status) {
		super(body, status);
		// TODO Auto-generated constructor stub
	}

}

package com.tr.envanter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tr.envanter.entity.Product;
import com.tr.envanter.request.ProductRequest;
import com.tr.envanter.responce.ProductResponce;
import com.tr.envanter.service.EnvanterDuzenlemeService;

@RestController
@RequestMapping(value = "/envanterApi/duzenleme")
public class EnvanterDuzenlemeController {

	@Autowired
	private EnvanterDuzenlemeService duzenlemeService;

	@PostMapping("/addProduct")
	public ProductResponce<Product> addNewProduct(
			@RequestBody ProductRequest<Product> request) {
		return new ProductResponce<Product>(
				duzenlemeService.addNewProduct(request.getBody()),
				HttpStatus.OK);

	}

	public ProductResponce<Product> removeProductById(
			@RequestBody ProductRequest<Product> request) {
		return new ProductResponce<Product>(
				duzenlemeService.removeProductById(request.getBody().getId()),
				HttpStatus.OK);

	}

	@PostMapping("/deleteProduct")
	public ProductResponce<Product> deleteProduct(
			@RequestBody ProductRequest<Product> request) {
		return new ProductResponce<Product>(
				duzenlemeService.deleteProductFromRepo(request.getBody()),
				HttpStatus.OK);

	}
	@PostMapping("/updateProduct")
	public ProductResponce<Product> updateProduct(
			@RequestBody ProductRequest<Product> request) {
		return new ProductResponce<Product>(
				duzenlemeService.updateProduct(request.getBody()),
				HttpStatus.OK);
	}

}

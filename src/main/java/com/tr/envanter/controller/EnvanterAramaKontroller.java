package com.tr.envanter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tr.envanter.entity.Product;
import com.tr.envanter.request.ProductRequest;
import com.tr.envanter.responce.ProductResponce;

@RestController
@RequestMapping("/envanterApi/arama")
public class EnvanterAramaKontroller {

	@PostMapping("/searchProducts")
	public ProductResponce<Product> searchProducts(
			ProductRequest<Product> request) {
		return null;

	}
}

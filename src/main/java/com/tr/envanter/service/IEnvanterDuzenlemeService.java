package com.tr.envanter.service;

import java.util.List;

import com.tr.envanter.entity.Product;

public interface IEnvanterDuzenlemeService {

	public Product addNewProduct(Product product);
	public List<Product> removeProductsById(List<Integer> productIds);
	public Product updateProduct(Product product);
	public void deleteProductFromRepo(Product product);

}

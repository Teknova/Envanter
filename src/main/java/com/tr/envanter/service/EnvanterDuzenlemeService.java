package com.tr.envanter.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.envanter.entity.Product;
import com.tr.envanter.entity.ProductHistory;
import com.tr.envanter.repository.EnvanterDuzenlemeRepository;
import com.tr.envanter.util.ProcessTypes;

@Service
public class EnvanterDuzenlemeService implements IEnvanterDuzenlemeService {

	@Autowired
	private EnvanterDuzenlemeRepository repository;
	@Autowired
	private EnvaterLogService logService;
	@Override
	public Product addNewProduct(Product product) {
		logService.addProductProcessToHistory(
				new ProductHistory(null, product.getId(), new Date(),
						ProcessTypes.ADD.toString(), null));
		return repository.save(product);
	}

	@Override
	public List<Product> removeProductsById(List<Integer> productIds) {
		List<Product> updatedProducts = new ArrayList<Product>();
		productIds.stream().forEach(id -> {
			Product product = repository.findById(id).get();
			Integer remainNumberOfProducts = product.getNumberOfProducts() - 1;
			if (remainNumberOfProducts <= product
					.getCriticalNumberOfProducts()) {
				// buraya log basılacak
			} else {
				product.setNumberOfProducts(remainNumberOfProducts);
				updatedProducts.add(repository.save(product));
				logService.addProductProcessToHistory(new ProductHistory(null,
						id, new Date(), ProcessTypes.REMOVE.toString(), null));
			}
		});
		return updatedProducts;
	}

	@Override
	public Product updateProduct(Product product) {

		logService.addProductProcessToHistory(
				new ProductHistory(null, product.getId(), new Date(),
						ProcessTypes.UPDATE.toString(), null));
		return null;
	}
	@Override
	public void deleteProductFromRepo(Product product) {
		repository.deleteById(product.getId());
		logService.addProductProcessToHistory(
				new ProductHistory(null, product.getId(), new Date(),
						ProcessTypes.DELETE.toString(), null));
	}

}

package com.tr.envanter.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
		Product product2 = repository.findById(product.getId()).get();

		if (Objects.nonNull(product.getName())
				&& !"".equalsIgnoreCase(product.getName())) {
			product2.setName(product.getName());
		}

		if (Objects.nonNull(product.getCategory()) && !""
				.equalsIgnoreCase(product.getCategory().getCategoryName())) {
			product2.setCategory(product.getCategory());
		}

		if (Objects.nonNull(product.getNumberOfProducts()) && !""
				.equalsIgnoreCase(product.getNumberOfProducts().toString())) {
			product2.setCriticalNumberOfProducts(product.getNumberOfProducts());
		}
		logService.addProductProcessToHistory(
				new ProductHistory(null, product.getId(), new Date(),
						ProcessTypes.UPDATE.toString(), null));
		return repository.save(product2);
	}
	@Override
	public void deleteProductFromRepo(Product product) {
		repository.deleteById(product.getId());
		logService.addProductProcessToHistory(
				new ProductHistory(null, product.getId(), new Date(),
						ProcessTypes.DELETE.toString(), null));
	}

}

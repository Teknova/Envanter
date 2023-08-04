package com.tr.envanter.repository;

import org.springframework.data.repository.CrudRepository;

import com.tr.envanter.entity.Product;

public interface EnvanterDuzenlemeRepository
		extends
			CrudRepository<Product, Integer> {

}

package com.tr.envanter.repository;

import org.springframework.data.repository.CrudRepository;

import com.tr.envanter.entity.ProductHistory;

public interface IEnvanterLogRepository
		extends
			CrudRepository<ProductHistory, Integer> {

}

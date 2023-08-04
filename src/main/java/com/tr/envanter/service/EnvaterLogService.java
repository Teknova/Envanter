package com.tr.envanter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.envanter.entity.ProductHistory;
import com.tr.envanter.repository.IEnvanterLogRepository;

@Service
public class EnvaterLogService {

	@Autowired
	private IEnvanterLogRepository logRepository;

	public ProductHistory addProductProcessToHistory(
			ProductHistory productHistory) {
		return logRepository.save(productHistory);
	}

}

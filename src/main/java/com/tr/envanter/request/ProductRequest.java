package com.tr.envanter.request;

import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

public class ProductRequest<T> extends RequestEntity<T> {

	public ProductRequest(T body, HttpMethod method, URI url) {
		super(body, method, url);
		// TODO Auto-generated constructor stub
	}

}

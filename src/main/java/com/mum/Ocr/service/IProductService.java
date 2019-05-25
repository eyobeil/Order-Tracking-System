package com.mum.Ocr.service;

import java.util.List;

import com.mum.Ocr.model.Product;

public interface IProductService {
	List<Product> getAllProducts();
	Product getProduct(Long id);
	void add(Product product);
	Product update(Product product);
	 void deleteProduct(Long id);

	Product getProductByProductId(long pid);
}

package com.mum.Ocr.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.Ocr.model.Product;
import com.mum.Ocr.repositroty.ProductRepository;
import com.mum.Ocr.service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductRepository productRepository;
	
public List<Product> getAllProducts(){
	List<Product> allProducts=new ArrayList<>();
	 productRepository.findAll()
	 .forEach(allProducts::add);
    return allProducts;
}
public Product getProduct(Long id) {
	return productRepository.getOne(id);
}
public void add(Product product) {
	productRepository.save(product);
	
}
public Product update(Product product) {
	return productRepository.save(product);	
}
public void deleteProduct(Long id) {
	productRepository.deleteById(id);
	
	
}

	@Override
	public Product getProductByProductId(long pid) {
		return productRepository.findByProductId(pid);
	}

}

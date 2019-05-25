package com.mum.Ocr.repositroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mum.Ocr.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByProductId(long pid);
}

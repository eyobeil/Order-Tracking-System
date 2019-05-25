package com.mum.Ocr.repositroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.Ocr.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
 Customer findByEmail(String email);
}
package com.mum.Ocr.repositroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.Ocr.model.OrderLine;
@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine,Long> {
 
}
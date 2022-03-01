package com.app.NeptuneDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.NeptuneDemo.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}

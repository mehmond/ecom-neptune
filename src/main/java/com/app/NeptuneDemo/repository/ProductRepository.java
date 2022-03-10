package com.app.NeptuneDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.NeptuneDemo.dto.ProductDTO;
import com.app.NeptuneDemo.model.Category;
import com.app.NeptuneDemo.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	public List<Product> findByCategory(Category category);

}

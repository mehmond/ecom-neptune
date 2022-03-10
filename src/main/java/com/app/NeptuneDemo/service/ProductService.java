package com.app.NeptuneDemo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.NeptuneDemo.dto.ProductDTO;
import com.app.NeptuneDemo.model.Category;
import com.app.NeptuneDemo.model.Product;
import com.app.NeptuneDemo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	
	public List<Product> index() {
		return productRepo.findAll();
	}

	public Product show(Long id) {
		Optional<Product> optional = productRepo.findById(id);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			throw new RuntimeException(" Category not found for id :: " + id);
		}
		return product;
	}
	
	public List<Product> findAllByCategory(Category category){
		return productRepo.findByCategory(category);
	}

	public void delete(Long id) {
		productRepo.deleteById(id);
	}

	public void save(Product product) {
		productRepo.save(product);
	}
}

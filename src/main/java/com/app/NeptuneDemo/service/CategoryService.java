package com.app.NeptuneDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.NeptuneDemo.model.Category;
import com.app.NeptuneDemo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	public List<Category> index() {
		return (List<Category>) categoryRepo.findAll();
	}

	public void save(Category category) {
		categoryRepo.save(category);
	}

	public Category show(Long id) {
		Optional<Category> optional = categoryRepo.findById(id);
		Category category = null;
		if (optional.isPresent()) {
			category = optional.get();
		} else {
			throw new RuntimeException(" Category not found for id :: " + id);
		}
		return category;
	}

	public void delete(Long id) {
		categoryRepo.deleteById(id);
	}

}

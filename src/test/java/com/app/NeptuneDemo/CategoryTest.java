package com.app.NeptuneDemo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.NeptuneDemo.controller.AdminCategoryController;
import com.app.NeptuneDemo.model.Category;
import com.app.NeptuneDemo.repository.CategoryRepository;

@SpringBootTest
@DataJpaTest
public class CategoryTest {

	@Autowired
	private CategoryRepository categoryRepo;

	@Test
	public void categoryTestSave() {
		Category savedCategory = categoryRepo.save(new Category("TEST CASE USING JUNIT"));
		assertEquals("Failed to add Category !", true, categoryRepo.save(savedCategory));
	}
}

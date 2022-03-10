package com.app.NeptuneDemo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.NeptuneDemo.controller.AdminCategoryController;
import com.app.NeptuneDemo.model.Category;
import com.app.NeptuneDemo.repository.CategoryRepository;

@DataJpaTest 
@RunWith(SpringRunner.class) 
@SpringBootTest(classes=NeptuneDemoApplication.class)
public class CategoryTest {

	@Autowired
	private CategoryRepository categoryRepo;

	@Test
	public void categoryTestSave() {
		Category category = new Category();
		category.setCategoryId((long)1002);
		category.setCategoryName("test using junit");
		Category savedCategory = categoryRepo.save(category);
		assertTrue(savedCategory.getCategoryId() > 0);
	}
}

package com.app.NeptuneDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.NeptuneDemo.model.Category;
import com.app.NeptuneDemo.service.CategoryService;

@Controller
public class AdminCategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/admin")
	public String dashboard() {
		return "adminIndex";
	}
	
	@GetMapping("/admin/manage-categories")
	public String index(Model model) {
		model.addAttribute("categories", categoryService.index());
		return "adminCategory";
	}

	@GetMapping("/admin/insert-category")
	public String insert(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "admin_form_category";
	}

	@PostMapping("/admin/save-category")
	public String save(Category category,  RedirectAttributes attributes) {
		categoryService.save(category);
		String message = (category.getCategoryId() == null) ? "Record succesfully added!" : "Record succesfully updated!";
		attributes.addFlashAttribute("message", message);
		return "redirect:/admin/manage-categories";
	}

	@GetMapping("/admin/edit-category/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		Category category = categoryService.show(id);
		model.addAttribute("category", category);
		return "admin_form_category";
	}

	@GetMapping("/admin/destroy-category")
	public String delete(Long id, RedirectAttributes attributes) {
		categoryService.delete(id);
		attributes.addFlashAttribute("deleteMessage", "Record succesfully deleted!");
		return "redirect:/admin/manage-categories";
	}

}

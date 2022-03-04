package com.app.NeptuneDemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.app.NeptuneDemo.dto.ProductDTO;
import com.app.NeptuneDemo.model.Category;
import com.app.NeptuneDemo.model.Product;
import com.app.NeptuneDemo.service.CategoryService;
import com.app.NeptuneDemo.service.ProductService;

@Controller
public class AdminProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/product-photos";

	@GetMapping("/admin/manage-products")
	public String index(Model model) {
		model.addAttribute("products", productService.index());
		return "adminProduct";
	}

	@GetMapping("/admin/insert-product")
	public String insert(Model model) {
		model.addAttribute("product", new ProductDTO());
		model.addAttribute("categories", categoryService.index());
		return "admin_form_product";
	}

	@PostMapping("/admin/save-product")
	public String save(ProductDTO products, @RequestParam("productImage") MultipartFile file,
			@RequestParam("imageName") String imageName) throws IOException {
		Product prod = new Product();
		prod.setCategory(categoryService.show(products.getCategoryId()));
		prod.setProductName(products.getProductName());
		prod.setProductPrice(products.getProductPrice());
		prod.setProductImage(products.getImageName());
		String imageUUId;
		if (!file.isEmpty()) {
			imageUUId = file.getOriginalFilename().toString();
			Path fileNameAndPath = Paths.get(uploadDirectory, imageUUId);
			Files.write(fileNameAndPath, file.getBytes());
		} else {
			imageUUId = imageName;
		}
		prod.setProductImage(imageUUId);
		prod.setProductId(products.getProductId());
		productService.save(prod);
		return "redirect:/admin/manage-products";
	}

	@GetMapping("/admin/edit-product/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		Product product = productService.show(id);
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductId());
		productDTO.setProductName(product.getProductName());
		productDTO.setCategoryId(product.getCategory().getCategoryId());
		productDTO.setProductPrice(product.getProductPrice());
		productDTO.setImageName(product.getProductImage());
		model.addAttribute("product", productDTO);
		model.addAttribute("categories", categoryService.index());
		return "admin_form_product";
	}

	@GetMapping("/admin/destroy-product")
	public String delete(Long id) {
		productService.delete(id);
		return "redirect:/admin/manage-products";
	}

}

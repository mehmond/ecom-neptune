package com.app.NeptuneDemo.controller;

import java.io.IOException;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.NeptuneDemo.dto.ProductDTO;
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
	private String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ssss").format(new Date());
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
			@RequestParam("imageName") String imageName, RedirectAttributes attributes) throws IOException {
		Product prod = new Product();
		prod.setCategory(categoryService.show(products.getCategoryId()));
		prod.setProductName(products.getProductName());
		prod.setProductPrice(products.getProductPrice());
		prod.setProductImage(products.getImageName());
		String imageUUId;
		if (!file.isEmpty()) {
			imageUUId = timeStamp + file.getOriginalFilename().toString();
			Path fileNameAndPath = Paths.get(uploadDirectory, imageUUId);
			Files.write(fileNameAndPath, file.getBytes());
		} else {
			imageUUId = imageName;
		}
		prod.setProductImage(imageUUId);
		prod.setProductId(products.getProductId());
		productService.save(prod);
		String message = (products.getProductId()==null) ? "Record succesfully added!" : "Record succesfully updated!";
		attributes.addFlashAttribute("message", message);
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
	public String delete(Long id, RedirectAttributes attributes) {
		productService.delete(id);
		attributes.addFlashAttribute("deleteMessage", "Record succesfully deleted!");
		return "redirect:/admin/manage-products";
	}

}

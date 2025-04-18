package com.springdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.dao.ProductRepository;
import com.springdemo.entities.Product;

public class ProductServices {
//	@Autowired
//	private ProductRepository repo;
//
//	public String displayHomePage(Model model) {
//		model.addAttribute("products", this.repo.findAll());
//		return "index.html";
//	}
//	
//	public String addProduct(@RequestParam String name, @RequestParam int quantity, @RequestParam double price,
//			@RequestParam String location) {
//		Product product = new Product();
//		product.setName(name);
//		product.setQuantity(quantity);
//		product.setPrice(price);
//		product.setLocation(location);
//		this.repo.save(product);
//		return "redirect:/home";
//	}

}

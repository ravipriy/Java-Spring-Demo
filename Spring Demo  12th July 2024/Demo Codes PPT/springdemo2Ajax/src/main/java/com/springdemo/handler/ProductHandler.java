package com.springdemo.handler;

import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.springdemo.dao.ProductRepository;
import com.springdemo.entities.Product;

@Controller
public class ProductHandler {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping({ "", "/", "/home" })
	public String displayHomePage(Model model) {
		List<Product> list = (List<Product>) productRepository.findAll();
		list.sort((Product p1, Product p2) -> p1.getName().compareTo(p2.getName()));

		double totalPrice = list.stream().mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();

		model.addAttribute("products", list);
		System.out.println(totalPrice);
		model.addAttribute("totalPrice", totalPrice);
		return "index.html";
	}

	@PostMapping("/addProduct")
	@ResponseBody
	public Map<String, Object> addProduct(@RequestParam("name") String name, @RequestParam("quantity") int quantity,
			@RequestParam("price") double price, @RequestParam("location") String location) {
		Map<String, Object> response = new HashMap<>();

		Optional<Product> existingProductOpt = productRepository.findByNameAndPrice(name, price);
		if (existingProductOpt.isPresent()) {
			Product existingProduct = existingProductOpt.get();
			existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
			productRepository.save(existingProduct);
			response.put("message", "Product updated successfully");
		} else {
			Product product = new Product();
			product.setName(name);
			product.setQuantity(quantity);
			product.setPrice(price);
			product.setLocation(location);
			productRepository.save(product);
			response.put("message", "Product added successfully");
		}

		List<Product> list = (List<Product>) productRepository.findAll();
		list.sort((Product p1, Product p2) -> p1.getName().compareTo(p2.getName()));
		double totalPrice = list.stream().mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();

		response.put("products", list);
		response.put("totalPrice", totalPrice);

		return response;
	}

	@GetMapping({ "/sell" })
	public String displaySellPage(Model model) {
		List<Product> list = (List<Product>) productRepository.findAll();
		list.sort((Product p1, Product p2) -> p1.getName().compareTo(p2.getName()));

		double totalPrice = list.stream().mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();

		model.addAttribute("products", list);
		System.out.println(totalPrice);
		model.addAttribute("totalPrice", totalPrice);
		return "sell.html";
	}

	@GetMapping({ "/getall" })
	@ResponseBody
	public List<Product> getAll(Model model) {
		List<Product> list = (List<Product>) productRepository.findAll();
		return list;
	}

	@PostMapping("/sellProduct")
	public ResponseEntity<String> sellProduct(@RequestParam Long id, @RequestParam int quantity) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
		if (quantity > product.getQuantity()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Insufficient quantity for product " + product.getName());
		}
		int newQuantity = product.getQuantity() - quantity;
		if (newQuantity <= 0) {
			newQuantity = 0;
			productRepository.delete(product);
			return ResponseEntity.ok("Product " + product.getName() + " removed from inventory.");
		} else {
			product.setQuantity(newQuantity);
			productRepository.save(product);
			return ResponseEntity.ok("Product Sold");
		}
	}

	@GetMapping("/getProducts")
	@ResponseBody
	public List<Product> getProducts() {
		List<Product> list=(List<Product>) productRepository.findAll();
		list.sort((Product p1, Product p2) -> p1.getName().compareTo(p2.getName()));
		return list;
	}

}

package com.example.demo.controller;

import java.util.List;
import com.example.demo.services.ProductsService;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.entities.ProductServiceability;
import com.example.demo.entities.Users;
import com.example.demo.entities.ProductsDTO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

	@Autowired
	private ProductsService productsService;

	@Autowired
	private UserService userService;

	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}

	@GetMapping("/items")
	public List<Product> getProducts() {
		return this.productsService.getProducts();
	}

	@GetMapping("/items/{productcode}")
	public Product getProduct(@PathVariable String productcode) {
		return this.productsService.getProduct(Long.parseLong(productcode));
	}

	@PostMapping(path = "/items", consumes = "application/json")
	public Product addProduct(@RequestBody Product product) {
		return this.productsService.addProduct(product);
	}

	@PutMapping("/items/{productcode}")
	public Product updateProduct(@RequestBody Product product, @PathVariable("productcode") long productcode) {
		this.productsService.updateProduct(product, productcode);
		return product;
	}

	@DeleteMapping("/items/{productcode}")
	public void deleteProduct(@PathVariable("productcode") long productcode) {
		this.productsService.deleteProduct(productcode);

	}

	@GetMapping("/items/search")
	public List<Product> searchProducts(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "productcode", required = false) Long productcode,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "minPrice", required = false) Double minPrice,
			@RequestParam(value = "maxPrice", required = false) Double maxPrice) {
		return this.productsService.searchProducts(name, productcode != null ? productcode : 0, brand, minPrice,
				maxPrice);
	}

	@GetMapping("/items/prices/{productcode}")
	public long getProductPrices(@PathVariable long productcode) {
		return this.productsService.getProductPrices(productcode);
	}

	@GetMapping("/items/prices")
	public List<ProductsDTO> getAllProductPrices() {
		return this.productsService.getAllProductPrices();
	}

	@GetMapping("/items/{productcode}/serviceability/{pincode}")
	public ProductServiceability getProductServiceability(@PathVariable("productcode") long productcode,
			@PathVariable("pincode") String pincode) {
		return productsService.getProductServiceability(productcode, pincode);
	}

	@GetMapping("/users")
	public List<Users> getUser() {

		return this.userService.getUser();
	}

	@GetMapping("/users/{id}")
	public Users getUser(@PathVariable String id) {
		return this.userService.getUser(Long.parseLong(id));
	}

	@PostMapping(path = "/users", consumes = "application/json")
	public Users addUser(@RequestBody Users user) {

		return this.userService.addUser(user);
	}

	@PutMapping("/users/{id}")
	public Users updateUser(@RequestBody Users user, @PathVariable("id") long id) {
		this.userService.updateUser(user, id);
		return user;

	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		this.userService.deleteUser(id);

	}

}

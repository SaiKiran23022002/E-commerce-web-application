package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entities.ProductsDTO;
import com.example.demo.entities.Product;
import com.example.demo.entities.ProductServiceability;
@Component
public interface ProductsService {

	public List<Product> getProducts();
	
	public Product getProduct(long productcode);

	public Product addProduct(Product product);

	public Product updateProduct(Product product, long productcode);
	
	public void deleteProduct(long productcode);
	
	public List<Product> searchProducts(String name, long productcode, String brand,Double minPrice, Double maxPrice);
	
	public long getProductPrices(long productcode);
	
	public List<ProductsDTO> getAllProductPrices();
	
	public ProductServiceability getProductServiceability(long productcode, String pincode);

	
	
}

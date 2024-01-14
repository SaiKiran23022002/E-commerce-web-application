package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductRepo;
import com.example.demo.entities.Product;
import com.example.demo.entities.ProductServiceability;
import com.example.demo.entities.ProductsDTO;

@Service

public class ProductServiceImpl implements ProductsService {
	@Autowired
	private ProductRepo productRepo;

	List<ProductServiceability> listServiceability;

	public ProductServiceImpl(ProductRepo productRepo) {

		this.productRepo = productRepo;

		if (productRepo.count() == 0) {
			productRepo.save(new Product(1, "Apple", "Iphone", 14, 114340,
					"Get the latest iphone 14 at the lowest prices  in our website",
					"https://th.bing.com/th/id/OIP.G-9VRxHhOl44omIC0WPi1AHaIw?w=166&h=196&c=7&r=0&o=5&dpr=1.5&pid=1.7"));
			productRepo.save(new Product(2, "Apple", "Iphone", 13, 73240,
					"Get the iphone 13 at cheap prices  in our website",
					"https://th.bing.com/th/id/OIP.m981000tTqZbyVNZGKDWqAHaOd?w=115&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7"));
		}
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepo.findAll();
	}

	@Override
	public Product getProduct(long productcode) {
		// TODO Auto-generated method stub

		return productRepo.findById(productcode)
				.orElseThrow(() -> new RuntimeException("Product with productcode " + productcode + " not found"));
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub

		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product, long productcode) {
		Product existingProduct = productRepo.findById(productcode)
				.orElseThrow(() -> new RuntimeException("Product with productcode " + productcode + " not found"));

		existingProduct.setBrand(product.getBrand());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setName(product.getName());
		existingProduct.setImage(product.getImage());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setVersion(product.getVersion());

		return productRepo.save(existingProduct);
	}

	@Override
	public void deleteProduct(long productcode) {
		// TODO Auto-generated method stub

		productRepo.deleteById(productcode);

	}

	@Override
	public List<Product> searchProducts(String name, long productcode, String brand, Double minPrice, Double maxPrice) {
		return ((Collection<Product>) productRepo.findAll()).stream()
				.filter(product -> (name == null || product.getName().contains(name))
						&& (productcode == 0 || (product.getProductcode()) == productcode)
						&& (brand == null || product.getBrand().contains(brand))
						&& (minPrice == null || product.getPrice() >= minPrice)
						&& (maxPrice == null || product.getPrice() <= maxPrice))
				.collect(Collectors.toList());
	}

	@Override
	public long getProductPrices(long productcode) {
		Product product = productRepo.findById(productcode).orElse(null);
		return (product != null) ? product.getPrice() : 0;
	}

	@Override
	public List<ProductsDTO> getAllProductPrices() {
		List<ProductsDTO> listprice = new ArrayList<>();
		List<Product> products = (List<Product>) productRepo.findAll();
		for (Product product : products) {
			long price = getProductPrices(product.getProductcode());

			listprice.add(new ProductsDTO(product.getProductcode(), price));
		}
		return listprice;
	}

	private String calculateDeliveryTime(String pincode) {
		if (pincode.equals("400001")) {
			return "1 day";
		} else if (pincode.equals("504001")) {
			return "2 days";
		} else if (pincode.equals("282001")) {
			return "3 days";
		} else if (pincode.equals("380001")) {
			return "4 days";
		} else if (pincode.equals("305001")) {
			return "5 days ";
		} else if (pincode.equals("211001")) {
			return "4 days";
		} else if (pincode.equals("143001")) {
			return "6 days";
		} else if (pincode.equals("531001")) {
			return "7 days ";
		} else if (pincode.equals("515001")) {
			return "7 days";
		} else if (pincode.equals("794102")) {
			return "6 days";
		} else if (pincode.equals("793101")) {
			return "5 days ";
		} else if (pincode.equals("700010")) {
			return "4 days";
		} else if (pincode.equals("507111")) {
			return "5 days ";
		} else if (pincode.equals("460001")) {
			return "6 days ";
		} else if (pincode.equals("845438")) {
			return "3 days ";
		} else if (pincode.equals("812001")) {
			return "2 days ";
		} else if (pincode.equals("441904")) {
			return "8 days ";
		} else if (pincode.equals("761126")) {
			return "5 days ";
		} else if (pincode.equals("321001")) {
			return "8 days ";
		} else if (pincode.equals("392001")) {
			return "9 days ";
		} else if (pincode.equals("425201")) {
			return "6 days ";
		} else if (pincode.equals("370001")) {
			return "8 days ";
		} else if (pincode.equals("532407")) {
			return "9 days ";
		} else if (pincode.equals("585401")) {
			return "8 days ";
		} else if (pincode.equals("243601")) {
			return "1 day ";
		} else if (pincode.equals("544536")) {
			return "10 days ";
		} else if (pincode.equals("543627")) {
			return "8 days ";
		} else if (pincode.equals("272153")) {
			return "7 days ";
		} else if (pincode.equals("327001")) {
			return "5 days ";
		} else if (pincode.equals("560002")) {
			return "6 days ";
		}

		return "Not possible for delivery";
	}

	private List<String> getProductServiceablePincodes(long productcode) {

		List<String> serviceablePincodes = new ArrayList<>();
		serviceablePincodes.add("400001");
		serviceablePincodes.add("504001");
		serviceablePincodes.add("282001");
		serviceablePincodes.add("380001");
		serviceablePincodes.add("305001");
		serviceablePincodes.add("211001");
		serviceablePincodes.add("143001");
		serviceablePincodes.add("531001");
		serviceablePincodes.add("515001");
		serviceablePincodes.add("794102");
		serviceablePincodes.add("793101");
		serviceablePincodes.add("700010");
		serviceablePincodes.add("507111");
		serviceablePincodes.add("460001");
		serviceablePincodes.add("845438");
		serviceablePincodes.add("812001");
		serviceablePincodes.add("441904");
		serviceablePincodes.add("761126");
		serviceablePincodes.add("321001");
		serviceablePincodes.add("392001");
		serviceablePincodes.add("425201");
		serviceablePincodes.add("370001");
		serviceablePincodes.add("532407");
		serviceablePincodes.add("585401");
		serviceablePincodes.add("243601");
		serviceablePincodes.add("544536");
		serviceablePincodes.add("543627");
		serviceablePincodes.add("272153");
		serviceablePincodes.add("327001");
		serviceablePincodes.add("560002");
		System.out.println(serviceablePincodes);
		return serviceablePincodes;

	}

	private boolean checkServiceability(Product product, String pincode) {
		List<String> serviceablePincodes = getProductServiceablePincodes(product.getProductcode());

		boolean value = serviceablePincodes.contains(pincode);
		if (value == true) {
			return serviceablePincodes.contains(pincode);
		} else {
			return false;
		}
	}

	@Override
	public ProductServiceability getProductServiceability(long productcode, String pincode) {
		Product product = getProduct(productcode);
		boolean isServiceable = checkServiceability(product, pincode);
		String expectedDeliveryTime = calculateDeliveryTime(pincode);
		return new ProductServiceability(pincode, expectedDeliveryTime, isServiceable);
	}

}

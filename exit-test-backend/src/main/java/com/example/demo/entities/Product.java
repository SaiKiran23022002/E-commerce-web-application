package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	private long productcode;

	private String brand;
	private String name;
	private long version;
	private long price;
	private String description;
	private String image;

	public Product() {
		super();
	}

	public Product(long productcode, String brand, String name, long version, long price, String description,
			String image) {
		super();
		this.productcode = productcode;
		this.brand = brand;
		this.name = name;
		this.version = version;
		this.price = price;
		this.description = description;
		this.image = image;
	}

	public Product(long productcode, long price) {
		super();
		this.productcode = productcode;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productcode=" + productcode + ", brand=" + brand + ", name=" + name + ", version=" + version
				+ ", price=" + price + ", description=" + description + ", image=" + image + "]";
	}

	public long getProductcode() {
		return productcode;
	}

	public void setProductcode(long productcode) {
		this.productcode = productcode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}

package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductDTO")
public class ProductsDTO {

	@Id
	private long productcode;

	private long price;

	public long getProductcode() {
		return productcode;
	}

	public void setProductcode(long productcode) {
		this.productcode = productcode;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public ProductsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductsDTO(long productcode, long price) {
		super();
		this.productcode = productcode;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductsDTO [productcode=" + productcode + ", price=" + price + "]";
	}

}

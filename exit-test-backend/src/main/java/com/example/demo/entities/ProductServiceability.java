package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductServiceability")
public class ProductServiceability {

	@Id
	private String pincode;
	private boolean servicable;
	private String deliverytime;

	public ProductServiceability(String productcode, String deliverytime, boolean servicable) {
		super();
		this.pincode = productcode;
		this.deliverytime = deliverytime;
		this.servicable = servicable;
	}

	@Override
	public String toString() {
		return "ProductServiceability [pincode=" + pincode + ", deliverytime=" + deliverytime + ", servicable="
				+ servicable + "]";
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(String deliverytime) {
		this.deliverytime = deliverytime;
	}

	public boolean isServicable() {
		return servicable;
	}

	public void setServicable(boolean servicable) {
		this.servicable = servicable;
	}

}

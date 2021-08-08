package com.shop;

public class Product {

	String code;
	String prdName;
	String brand;
	double price;
	int quantity;

	public Product( String code, String prdName, String brand, double price, int quantity) {
		super();
		this.code = code;
		this.prdName = prdName;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return prdName;
	}

	public void setName(String prdName) {
		this.prdName = prdName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

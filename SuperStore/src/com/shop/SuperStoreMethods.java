package com.shop;

import java.util.List;
import java.util.Map;

public interface SuperStoreMethods {
	void displayAllProducts(Map<String, List<Product>>  map);
	void displayProduct(List<Product> list);
	List<Product> search(Map<String, List<Product>> map,String prdName);
	void placeOrder(Map<String, List<Product>>  map);
}

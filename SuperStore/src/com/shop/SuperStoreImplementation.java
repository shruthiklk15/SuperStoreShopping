package com.shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SuperStoreImplementation implements SuperStoreMethods {

	@Override
	public void displayAllProducts(Map<String, List<Product>> map) {
		for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
			if (entry.getValue().size() > 1) {
				for (int i = 0; i < entry.getValue().size(); i++) {
					Product p = entry.getValue().get(i);
					System.out.println(p.prdName + " " + p.brand + " " + p.quantity);
				}
				continue;
			}
			Product p = entry.getValue().get(0);
			System.out.printf("%-10s %-30s %-20s %-10s %-10s\n", p.code, p.prdName, p.brand, p.price, p.quantity);
		}
	}

	@Override
	public List<Product> search(Map<String, List<Product>> map, String prdName) {
		if (map.containsKey(prdName)) {
			displayProduct(map.get(prdName));
			return map.get(prdName);
		} else {
			System.out.println("Product not found, please enter valid product name");
			return null;
		}
	}

	@Override
	public void placeOrder(Map<String, List<Product>> map) {
		System.out.println("Enter the product name");
		Scanner scan = new Scanner(System.in);
		String prdName = scan.nextLine();

		List<Product> list = search(map, prdName);
		System.out.println(list);

		String brand = "";
		if (list != null) {
			System.out.println("Enter the brand name");
			brand = scan.nextLine();

		} else {
			placeOrder(map);
		}
		System.out.println("Enter the quantity you want to buy");
		int qty = 0;
		try {
			qty = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Enter valid quantity");
			placeOrder(map);
		}
		try {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).brand.equals(brand) && list.get(i).prdName.equals(prdName)) {
					if (list.get(i).quantity > qty) {
						double amount = list.get(i).price * qty;
						System.out.println("Here's the amount you have to pay " + amount);
					} else {
						System.out.print(" Sorry! we are out of stock");
						return;
					}
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Product not found");
		}
	}

	@Override
	public void displayProduct(List<Product> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Name:" + list.get(i).prdName + "	Brand: " + list.get(i).brand + " " + "	Qty:"
					+ list.get(i).quantity + "	Price:" + list.get(i).price);
			System.out.println();
		}
	}

}
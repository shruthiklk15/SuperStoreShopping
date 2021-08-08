package com.shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SuperStoreCheckoutMain {

	public static void main(String[] args) throws Exception {
		SuperStoreMethods store = new SuperStoreImplementation();
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		int choice=0;
		
		Map<String, List<Product>> map = new LinkedHashMap<String, List<Product>>();
		BufferedReader br = new BufferedReader(
				new FileReader("D:\\open-soure\\java\\SuperStoreFinal\\SuperStore\\src\\com\\shop\\shopFile.csv"));

		String line = null;
		while ((line = br.readLine()) != null) {
			String[] str = line.split(",");
			List<Product> list = new ArrayList<>();

			String code = str[0];
			String prdName = str[1];
			String brand = str[2];
			double price = Double.parseDouble(str[3]);
			int quantity = Integer.parseInt(str[4]);
			Product p = new Product(code, prdName, brand, price, quantity);
			list.add(p);
			if (map.containsKey(p.prdName)) {
				map.get(p.prdName).add(p);
			} else {
				map.put(p.prdName, list);
			}
		}
		System.out.println("1.Display all products\n2.Search product\n3.Place order\n4.Exit");

		while (true) {
			System.out.println("Enter the choice");
			
			try {
				
				 choice = Integer.parseInt(scan.next());
			}
			catch(Exception e) {
				System.out.println("Enter valid choice");
			}

			switch (choice) {
			case 1:
				store.displayAllProducts(map);
				break;
			case 2:
				System.out.println("Enter the product name");
				String name = scan2.nextLine();
				store.search(map, name);
				break;
			case 3:
				store.placeOrder(map);
				break;
			case 4:
				System.out.print("Thank you for shopping");
				System.exit(0);
			}
		}
	}
}

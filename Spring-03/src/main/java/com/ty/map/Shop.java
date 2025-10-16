package com.ty.map;

import java.util.Map;

public class Shop {
	String name;
	Map<String, Double> items;

	public void display() {
		System.out.println("=======" + name + "=========");
		System.out.println("----------Menu-----------");
		for (Map.Entry<String, Double> entry : items.entrySet()) {
			System.out.println(entry.getKey() + " ==> " + entry.getValue());
		}
	}

	public Shop(String name, Map<String, Double> items) {
		this.name = name;
		this.items = items;
	}

}

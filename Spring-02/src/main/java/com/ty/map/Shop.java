package com.ty.map;

import java.util.Map;

public class Shop {
	private String name;
	private Map<String, Double> items;

	public void display() {
		System.out.println("=======" + name + "=========");
		System.out.println("----------Menu-----------");
		for (Map.Entry<String, Double> entry : items.entrySet()) {
			System.out.println(entry.getKey() + " ==> " + entry.getValue());
		}
	}
	//getter 
	//setter
}

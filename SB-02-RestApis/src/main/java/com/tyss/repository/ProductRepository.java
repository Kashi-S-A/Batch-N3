package com.tyss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	//custom query
	@Query("select p from Product p where p.price>?1 and p.price<?2")
	public List<Product> getProductsBetweenPrice(Double fromPrice, Double toPrice);
	
	@Query("select p from Product p where p.units=:units")
//	@Query(value = "select * from products where units=units",nativeQuery = true)
	public List<Product> getProductsByUnits(Integer units);
	
	
	//custom methods
	public List<Product> findByUnits(Integer units);
	
	public List<Product> findByPriceBetween(Double from,Double to);
	
	public List<Product> findByNameContainingAllIgnoringCase(String name);
}

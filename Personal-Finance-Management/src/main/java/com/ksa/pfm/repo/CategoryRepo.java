package com.ksa.pfm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ksa.pfm.model.Category;
import com.ksa.pfm.model.User;

public interface CategoryRepo extends JpaRepository<Category, Long> {

	public List<Category> findByUser(User user);
	
	public Category findByName(String name);
}

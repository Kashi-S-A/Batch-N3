package com.ksa.pfm.service;

import java.util.List;

import com.ksa.pfm.model.Category;
import com.ksa.pfm.model.User;

public interface CategoryService {

	public List<Category> findByUser(User user);

	public Category saveCategory(Category category);

	public Category findById(Long catId);

	public Category findByName(String catName);

	List<Category> findAll();
}

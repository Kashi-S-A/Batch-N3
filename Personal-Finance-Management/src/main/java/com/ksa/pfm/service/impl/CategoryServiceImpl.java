package com.ksa.pfm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksa.pfm.model.Category;
import com.ksa.pfm.model.User;
import com.ksa.pfm.repo.CategoryRepo;
import com.ksa.pfm.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<Category> findByUser(User user) {
		return categoryRepo.findByUser(user);
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category findById(Long catId) {
		return categoryRepo.findById(catId).orElseThrow(() -> new RuntimeException("Category Not Found"));
	}

	@Override
	public Category findByName(String catName) {
		return categoryRepo.findByName(catName);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}


}

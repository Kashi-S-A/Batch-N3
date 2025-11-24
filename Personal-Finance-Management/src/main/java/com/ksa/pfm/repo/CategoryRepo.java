package com.ksa.pfm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ksa.pfm.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}

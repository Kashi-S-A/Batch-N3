package com.ksa.pfm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ksa.pfm.model.Budget;

public interface BudgetRepo extends JpaRepository<Budget, Long> {

}

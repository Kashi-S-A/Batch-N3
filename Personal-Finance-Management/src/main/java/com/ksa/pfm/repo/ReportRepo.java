package com.ksa.pfm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ksa.pfm.model.Transaction;
import com.ksa.pfm.model.TransactionType;

// JpaRepository for the Transaction entity
public interface ReportRepo extends JpaRepository<Transaction, Long> {

	/**
	 * Fetches transactions filtered by user, type, month, and year for reports.
	 * NOTE: Uses PostgreSQL functions (EXTRACT and CAST) for date comparison.
	 */
	@Query("""
        SELECT t FROM Transaction t
        WHERE t.user.id = :userId
        AND t.type = :type
        AND EXTRACT(MONTH FROM CAST(t.date AS date)) = :month 
        AND EXTRACT(YEAR FROM CAST(t.date AS date)) = :year
        ORDER BY t.date ASC
        """)
	public List<Transaction> findMonthlyReports(
	        @Param("userId") Long userId,
	        @Param("type") TransactionType type,
	        @Param("month") int month,
	        @Param("year") int year
    );
}
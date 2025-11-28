package com.ksa.pfm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ksa.pfm.model.Transaction;
import com.ksa.pfm.model.TransactionType;
import com.ksa.pfm.model.User;


public interface TransactionRepo extends JpaRepository<Transaction, Long> {

	// custom queries
	@Query("""
    SELECT t FROM Transaction t
    WHERE (t.user.id = :userId)
    AND(:type IS NULL OR t.type = :type)
    AND (:catId IS NULL OR t.category.id = :catId)
    AND (:fromDate = '' OR t.date >= :fromDate)
    AND (:toDate = '' OR t.date <= :toDate)
    """)
	public List<Transaction> filterTrans(@Param("userId")Long userId,@Param("type") TransactionType type, @Param("catId") Long catId,  @Param("fromDate") String fromDate,  @Param("toDate") String toDate);
	
	List<Transaction> findByUser(User user);
}

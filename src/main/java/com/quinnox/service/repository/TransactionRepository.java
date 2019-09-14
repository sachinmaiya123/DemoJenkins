package com.quinnox.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quinnox.service.entity.TransactionResource;
import com.quinnox.service.entity.UserTransactions;

@Repository
public interface TransactionRepository extends JpaRepository<UserTransactions, Long>{

	/*@Query(nativeQuery=true, value="select * from transaction_resource where user_id= ?1")
	public List<UserTransactions> getAllTransactionsByUserId(long userId);*/
	
	
	
}

package com.quinnox.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amazonaws.jmespath.JmesPathExpression;
import com.quinnox.service.entity.TransactionResource;
import com.quinnox.service.entity.UserTransactions;

@Repository
public interface ResourceRepository extends JpaRepository<TransactionResource, Long>{

	@Query(nativeQuery=true, value="select * from transaction_resource where user_id = ?1 and transaction_id = ?2")
	public List<TransactionResource> getAllResourceForTransaction(long userId, long transactionId);
	
/*	@Query(nativeQuery=true, value="insert into transaction_resource values ( "+?1+")" )
	public String putImagesWithTransactionDetails(long resourceId, long userId, long transactionId);*/
	
	@Query(nativeQuery=true, value="select * from transaction_resource where user_id= ?1 and transaction_id = ?2")
	public List<TransactionResource> getImageURL(long userId, long transactionId);
}

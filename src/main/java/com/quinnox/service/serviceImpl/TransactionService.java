package com.quinnox.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.service.entity.TransactionResource;
import com.quinnox.service.entity.UserTransactions;
import com.quinnox.service.repository.ResourceRepository;
import com.quinnox.service.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private ResourceRepository resourceRepository;
	
	public long addNewTransaction(UserTransactions transaction) {
		return transactionRepository.save(transaction).getTransactionId();
	}
	
	public List<UserTransactions> getAllTransactions(){
		return transactionRepository.findAll();
	}
	
	/*public List<TransactionResource> getAllTransactionsByUserId(long userId){
		 List<TransactionResource> list = resourceRepository.getAllTransactionsByUserId(userId);
		 list.forEach(l -> System.out.println(l));
		 return list;
	}*/
	
}

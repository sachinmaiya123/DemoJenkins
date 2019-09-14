package com.quinnox.service.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.service.entity.TransactionResource;
import com.quinnox.service.entity.TransactionResult;
import com.quinnox.service.entity.UserTransactions;
import com.quinnox.service.serviceImpl.TransactionResourceService;
import com.quinnox.service.serviceImpl.TransactionService;

@RestController
@RequestMapping("/rest/transactions")
public class UserTransactionController {

	private static long counter = 0;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private TransactionResourceService resourceService;
	
	@GetMapping(value="/getAllTransactions")
	public List<UserTransactions> getAllTransactions(){
		return transactionService.getAllTransactions();
	}
	
	/*@GetMapping(value="/getTransactions/{userId}")
	public List<UserTransactions> getAllTransactionByUserId(@PathVariable("userId") long userId){
		List<TransactionResource> resourceList = transactionService.getAllTransactionsByUserId(userId);
		List<TransactionResult> resultList = new ArrayList<TransactionResult>(); 
		for(TransactionResource resource : resourceList) {
			
		}
		return transactionList;
	}*/

	@GetMapping(value="/getTransactions/{userId}/{transactionId}")
	public List<String> getTransactionsResult(@PathVariable("userId") long userId, @PathVariable("transactionId") long transactionId){
		List<TransactionResource> urls = resourceService.getImagesURL(userId, transactionId);
		List<String> resultList = new ArrayList<>();
		for(TransactionResource resource : urls){
			StringBuffer sb = new StringBuffer().append(resource.getImageURL());
			resultList.add(sb.toString());
		}
		return resultList;
	}
	
	@PostMapping(value="/addTransaction/{userId}", consumes="application/json")
	public String addTransaction(@RequestBody UserTransactions userTransaction, @PathVariable("userId") long userId) {
		Date date = new Date();
		long transactionId = date.getTime(); // transaction id generated
		System.err.println(userId);
		userTransaction.setTransactionId(transactionId);
		try {
			
			transactionService.addNewTransaction(userTransaction);
			for(String images : userTransaction.getImageURL()){
				counter++;
				TransactionResource resource = new TransactionResource();
				resource.setResourceId(counter);
				resource.setImageURL(images);
				resource.setTransactionId(transactionId);
				resource.setUserId(userId);
				resourceService.uploadResources(resource);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "error in making transaction";
		}
		return "Transaction successfull with TransactionID = "+transactionId;
	}
	
}

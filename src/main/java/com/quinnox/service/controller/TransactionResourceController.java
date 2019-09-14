package com.quinnox.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.service.entity.TransactionResource;
import com.quinnox.service.serviceImpl.TransactionResourceService;

@RestController
@RequestMapping("/rest/resource")
public class TransactionResourceController {

	@Autowired
	private TransactionResourceService transactionResourceService;
	
	@GetMapping(value="/getAllResources")
	public List<TransactionResource> getAllResources(){
		return transactionResourceService.getAllResources();
	}
	@GetMapping(value="/getResource/{userId}/{transactionId}")
	public List<TransactionResource> getAllResourcesByTransaction(@PathVariable("userId") long userId, @PathVariable("transactionId") long transactionId){
		System.out.println(userId);
		System.out.println(transactionId);
		return transactionResourceService.getAllResourcesByTransaction(userId, transactionId);
	}
	
}

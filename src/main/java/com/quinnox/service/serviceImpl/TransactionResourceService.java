package com.quinnox.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.quinnox.service.entity.TransactionResource;
import com.quinnox.service.repository.ResourceRepository;

@Service
public class TransactionResourceService {
	
	@Autowired
	private ResourceRepository resourceRepository;
	
	public List<TransactionResource> getAllResources(){
		return resourceRepository.findAll();
	}
	
	public List<TransactionResource> getAllResourcesByTransaction(long userId, long transactionId){
        return resourceRepository.getAllResourceForTransaction(userId, transactionId);		
	}
	
	public String uploadResources(TransactionResource resource) {
		try {
			resourceRepository.save(resource);
			return "resource added successfully";
		}catch(Exception e) {
			e.printStackTrace();
			return "error in uploading images";
		}
	}
	
	
	public List<TransactionResource> getImagesURL(long userId, long transactionId){
		return resourceRepository.getImageURL(userId, transactionId);
	}
	
}

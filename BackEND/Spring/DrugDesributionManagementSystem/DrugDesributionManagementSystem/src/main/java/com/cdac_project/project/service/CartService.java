package com.cdac_project.project.service;

import org.springframework.stereotype.Service;

import com.cdac_project.project.exception.*;
import com.cdac_project.project.model.*;
import com.cdac_project.project.request.AddItemRequest;

@Service
public interface CartService {
	
	public Cart createCart(Pharmacist pharmacist);
	public String addCartMedicine(Long p_ID,AddItemRequest req) throws MedicineException;
	public Cart findUserCart(Long p_ID);
}

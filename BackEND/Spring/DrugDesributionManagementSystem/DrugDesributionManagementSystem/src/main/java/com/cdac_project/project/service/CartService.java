package com.cdac_project.project.service;

import org.springframework.stereotype.Service;

import com.cdac_project.project.exception.*;
import com.cdac_project.project.model.*;
import com.cdac_project.project.request.AddMedicinerequest;

@Service
public interface CartService {
	
	public Cart createCart(Pharmacist pharmacist);
	public String addCartMedicine(int Pharmacistid,AddMedicinerequest req) throws MedicineException, CartException, PharmacistException, CartMedicineException;
	public Cart findPharmacistCart(int p_ID);
}

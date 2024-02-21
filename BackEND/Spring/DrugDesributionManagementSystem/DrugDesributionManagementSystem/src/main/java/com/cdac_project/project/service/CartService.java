package com.cdac_project.project.service;

import org.springframework.stereotype.Service;

import com.cdac_project.project.exception.*;
import com.cdac_project.project.model.*;
import com.cdac_project.project.request.AddMedicineRequest;

@Service
public interface CartService {

	public Cart createCart(int pharmacist);
	public Cart createCart(Pharmacist pharmacist);
	public String addCartMedicine(int Pharmacistid, int req)throws MedicineException, CartException, CartMedicineException, PharmacistException ;
    public String addCartMedicine(int Pharmacistid, AddMedicineRequest req)throws MedicineException, CartException, CartMedicineException, PharmacistException ;
    public Cart findPharmacistCart(int p_ID);
}

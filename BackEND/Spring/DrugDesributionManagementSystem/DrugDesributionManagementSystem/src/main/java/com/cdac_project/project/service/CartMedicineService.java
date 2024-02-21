package com.cdac_project.project.service;

import org.springframework.stereotype.Service;

import com.cdac_project.project.exception.CartException;
import com.cdac_project.project.exception.CartMedicineException;
import com.cdac_project.project.exception.MedicineException;
import com.cdac_project.project.exception.PharmacistException;
import com.cdac_project.project.model.Cart;
import com.cdac_project.project.model.CartMedicine;
import com.cdac_project.project.model.Medicine;

@Service
public interface CartMedicineService {

	public CartMedicine createCartMedicine(CartMedicine cartMedicine)throws CartMedicineException, PharmacistException;
	public  CartMedicine updateCartMedicine(int PharmacistID ,int medsid , CartMedicine cartMedicine) throws CartMedicineException, PharmacistException;
	public void removeCartMedicine(int pharmacistID , int cartMedicineID) throws CartMedicineException , PharmacistException  ;
	public CartMedicine findCartMedicineByID(int CartMedicineID)throws CartMedicineException;
	CartMedicine isCartMedicineExist(Cart cart, int PID, Medicine medicine, int quantity)
			throws CartException, MedicineException, PharmacistException;
	
}

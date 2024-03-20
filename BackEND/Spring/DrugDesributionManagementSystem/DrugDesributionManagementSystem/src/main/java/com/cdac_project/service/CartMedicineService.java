package com.cdac_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdac_project.exception.CartException;
import com.cdac_project.exception.CartMedicineException;
import com.cdac_project.exception.MedicineException;
import com.cdac_project.exception.PharmacistException;
import com.cdac_project.model.Cart;
import com.cdac_project.model.CartMedicine;
import com.cdac_project.model.Medicine;

@Service
public interface CartMedicineService {

	public CartMedicine createCartMedicine(CartMedicine cartMedicine)throws CartMedicineException, PharmacistException;
	public  CartMedicine updateCartMedicine(int PharmacistID ,int medsid , CartMedicine cartMedicine) throws CartMedicineException, PharmacistException;
	public void removeCartMedicine(int pharmacistID , int cartMedicineID) throws CartMedicineException , PharmacistException  ;
	public CartMedicine findCartMedicineByID(int CartMedicineID)throws CartMedicineException;
	public CartMedicine isCartMedicineExist(Cart cart, int PID, Medicine medicine, int quantity)
			throws CartException, MedicineException, PharmacistException;
	 public void clearCart(int pharmacistId);
	public List<CartMedicine> getCartMedicinesByPharmacistId(int pharmacistId);
}

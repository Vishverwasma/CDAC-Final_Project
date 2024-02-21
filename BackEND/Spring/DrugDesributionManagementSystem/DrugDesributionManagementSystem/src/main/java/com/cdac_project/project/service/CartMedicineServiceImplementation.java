package com.cdac_project.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac_project.project.exception.CartException;
import com.cdac_project.project.exception.CartMedicineException;
import com.cdac_project.project.exception.MedicineException;
import com.cdac_project.project.exception.PharmacistException;
import com.cdac_project.project.model.Cart;
import com.cdac_project.project.model.CartMedicine;
import com.cdac_project.project.model.Medicine;
import com.cdac_project.project.model.Pharmacist;
import com.cdac_project.project.repository.CartMedicineRepository;
import com.cdac_project.project.repository.CartRepository;

@Service
public class CartMedicineServiceImplementation implements CartMedicineService{

	private CartMedicineRepository cartMedicineRepository;
	private PharmacistService pharmacistService;
	private CartRepository cartRepository;
	
	
	@Autowired
	public CartMedicineServiceImplementation(CartMedicineRepository cartMedicineRepository,
			PharmacistService pharmacistService, CartRepository cartRepository) {
		super();
		this.cartMedicineRepository = cartMedicineRepository;
		this.pharmacistService = pharmacistService;
		this.cartRepository = cartRepository;
	}

	@Override
	public CartMedicine createCartMedicine(CartMedicine cartMedicine)
			throws CartMedicineException, PharmacistException {
		// TODO Auto-generated method stub
		
		cartMedicine.setQuantity((int) 1);
        cartMedicine.setPrice(cartMedicine.getMedicine().getUnitPrice() * cartMedicine.getQuantity());

        CartMedicine createdCartMedicine = cartMedicineRepository.save(cartMedicine);
        return createdCartMedicine;
	}

	

	@Override
	public CartMedicine isCartMedicineExist(Cart cart, int PID, Medicine medicine ,int quantity)
			throws CartException, MedicineException, PharmacistException {
		// TODO Auto-generated method stub
		
		 CartMedicine cm = cartMedicineRepository.isCartMedicineExist(cart, PID, medicine,quantity);
	        return cm;
	}

	@Override
	public void removeCartMedicine(int pharmacistID, int cartMedicineID)
			throws CartMedicineException, PharmacistException {
		// TODO Auto-generated method stub
		
		CartMedicine cartMedicine = findCartMedicineByID(cartMedicineID);
        Pharmacist pharmacist = pharmacistService.findPharmacistById(cartMedicine.getPharmacistId());
        Pharmacist reqPharmacist = pharmacistService.findPharmacistById(pharmacistID);
        if (pharmacist.getId().equals(reqPharmacist.getId())) {
            cartMedicineRepository.deleteById(cartMedicineID);
        } else {
            throw new PharmacistException("This Medicine Does not Belong To Your Cart!");
        }
	}

	@Override
	public CartMedicine findCartMedicineByID(int CartMedicineID) throws CartMedicineException {
		// TODO Auto-generated method stub
		
		Optional<CartMedicine> opt = cartMedicineRepository.findById(CartMedicineID);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new CartMedicineException("Medicine Not Found!");
        }

	@Override
	public CartMedicine updateCartMedicine(int PharmacistID, int medsid, CartMedicine cartMedicine)
			throws CartMedicineException, PharmacistException {
		 CartMedicine meds = findCartMedicineByID(medsid);
	        Pharmacist p = pharmacistService.findPharmacistById(PharmacistID);

	        if (p.getId().equals(PharmacistID)) {
	            meds.setQuantity(meds.getQuantity());
	            meds.setPrice(meds.getPrice() * meds.getMedicine().getUnitPrice());
	        }
	        return cartMedicineRepository.save(meds);
	    }

}

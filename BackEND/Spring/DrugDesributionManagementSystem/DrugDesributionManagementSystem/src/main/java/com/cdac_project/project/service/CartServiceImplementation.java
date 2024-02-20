package com.cdac_project.project.service;

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
import com.cdac_project.project.request.AddMedicinerequest;

@Service
public class CartServiceImplementation implements CartService {

	private CartRepository cartRepository;
	private CartMedicineService cartMedicineService;
	private MedicineService medicineService;
	
	public CartServiceImplementation(CartRepository cartRepository, CartMedicineService cartMedicineService,
			MedicineService medicineService) {
		super();
		this.cartRepository = cartRepository;
		this.cartMedicineService = cartMedicineService;
		this.medicineService = medicineService;
	}

	@Override
	public Cart createCart(Pharmacist pharmacist) {
		// TODO Auto-generated method stub
		
		Cart cart = new Cart();
		cart.setPharmacist(pharmacist);
		return cartRepository.save(cart);
	}

	@Override
	public String addCartMedicine(int Pharmacistid, AddMedicinerequest req) throws MedicineException, CartException, CartMedicineException, PharmacistException {
		// TODO Auto-generated method stub
		
		Cart cart = cartRepository.findByPharmacistId(Pharmacistid);
		Medicine medicine = medicineService.findMedicineById(req.getMedicineID());
		CartMedicine isPresent = cartMedicineService.isCartMedicineExist(cart, medicine, Pharmacistid);
		
		if(isPresent==null) {
			CartMedicine cartMedicine = new CartMedicine();
			cartMedicine.setMedicine(medicine);
			cartMedicine.setCart(cart);
			cartMedicine.setQuantity(req.getQuantity());
			cartMedicine.setPharmacistId(Pharmacistid);
			int price = req.getQuantity()*medicine.getUnitPrice();
			cartMedicine.setPrice(price);
			cartMedicine.setQuantity(req.getQuantity());
			
			CartMedicine createdCartMedicine = cartMedicineService.createCartMedicine(cartMedicine);
			cart.getCartMedicine().add(createdCartMedicine);
		}
		return "Item added to Cart !";
	}

	@Override
	public Cart findPharmacistCart(int p_ID) {
		// TODO Auto-generated method stub
		
		Cart cart= cartRepository.findByPharmacistId(p_ID);
		int totalPrice = 0;
		int totalMedicine = 0;
		for(CartMedicine cartMedicine : cart.getCartMedicine()) {
			totalPrice=totalPrice+cartMedicine.getPrice();
			totalMedicine=totalMedicine+cartMedicine.getQuantity();			
		}
		cart.setTotalItem(totalMedicine);
		cart.setTotalPrice(totalPrice);
		return cartRepository.save(cart);
	}

	
}

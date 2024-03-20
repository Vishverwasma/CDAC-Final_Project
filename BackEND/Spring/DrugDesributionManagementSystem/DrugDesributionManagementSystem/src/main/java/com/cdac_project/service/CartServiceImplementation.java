package com.cdac_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac_project.exception.CartException;
import com.cdac_project.exception.CartIsEmptyExcetpion;
import com.cdac_project.exception.CartMedicineException;
import com.cdac_project.exception.MedicineException;
import com.cdac_project.exception.PharmacistException;
import com.cdac_project.model.Cart;
import com.cdac_project.model.CartMedicine;
import com.cdac_project.model.Medicine;
import com.cdac_project.model.Pharmacist;
import com.cdac_project.repository.CartRepository;
import com.cdac_project.request.AddMedicineRequest;

@Service
public class CartServiceImplementation implements CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartMedicineService cartMedicineService;
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private PharmacistService pharmacistService;
	
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
	public String addCartMedicine(int Pharmacistid, AddMedicineRequest req) throws MedicineException, CartException, CartMedicineException, PharmacistException {
		// TODO Auto-generated method stub
		
		Cart cart = cartRepository.findByPharmacistId(Pharmacistid);
		Medicine medicine = medicineService.findMedicineById(req.getMedicineID());
		int quantity = medicine.getQuantity();
		CartMedicine isPresent = cartMedicineService.isCartMedicineExist(cart, Pharmacistid, medicine,quantity);
		
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
	public Cart findPharmacistCart(int p_ID) throws  CartException {
		// TODO Auto-generated method stub
		try {
	        Cart cart = cartRepository.findByPharmacistId(p_ID);
	        if (cart == null) {
	            System.out.println("Cart is currently empty");
	            return null;
	        }
	        int totalPrice = 0;
	        int totalMedicine = 0;
	        for(CartMedicine cartMedicine : cart.getCartMedicine()) {
	            totalPrice += cartMedicine.getPrice();
	            totalMedicine += cartMedicine.getQuantity();            
	        }
	        cart.setTotalItem(totalMedicine);
	        cart.setTotalPrice(totalPrice);
	        cartRepository.save(cart);
	        return cart;
	    } catch (Exception e) {
	        // Handle the exception, log it, and return an appropriate response
	        System.out.println("Multiple carts found for pharmacist ID: " + p_ID);
	        return null;
	    }
	}

	@Override
	public Cart createCart(int pharmacistId) throws PharmacistException {
		   Pharmacist pharmacist = pharmacistService.findPharmacistById(pharmacistId);
		    if (pharmacist == null) {
		        throw new PharmacistException("Pharmacist not found with ID: " + pharmacistId);
		    }
		    Cart cart = new Cart();
		    cart.setPharmacist(pharmacist);
		    return cartRepository.save(cart);
		}


	@Override
	public String addCartMedicine(int Pharmacistid, int medicineId)
			throws MedicineException, CartException, CartMedicineException, PharmacistException {
		Cart cart = cartRepository.findByPharmacistId(Pharmacistid);
	    Medicine medicine = medicineService.findMedicineById(medicineId);
	    CartMedicine cartMedicine = new CartMedicine();
	    cartMedicine.setMedicine(medicine);
	    cartMedicine.setCart(cart);
	    CartMedicine createdCartMedicine = cartMedicineService.createCartMedicine(cartMedicine);
	    return "Item added to Cart!";
	}

	@Override
	public void clearCart(int pharmacistId) throws CartException {
		// TODO Auto-generated method stub
		 Cart cart = cartRepository.findByPharmacistId(pharmacistId);
	        if (cart == null) {
	            throw new CartException("Cart not found for pharmacist with ID: " + pharmacistId);
	        }
	        cart.getCartMedicine().clear();
	        
	        cartRepository.save(cart);
	}

	
}

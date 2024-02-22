package com.cdac_project.service;

import org.springframework.stereotype.Service;

import com.cdac_project.exception.CartException;
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

	@Override
	public Cart createCart(int pharmacist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCartMedicine(int Pharmacistid, int medicineId)
			throws MedicineException, CartException, CartMedicineException, PharmacistException {
		// Retrieve the Cart entity associated with the pharmacistId
	    Cart cart = cartRepository.findByPharmacistId(Pharmacistid);
	    // Retrieve the Medicine entity associated with the medicineId
	    Medicine medicine = medicineService.findMedicineById(medicineId);
	    
	    // Perform any necessary validation or checks
	    
	    // Create a new CartMedicine entity and populate its fields
	    CartMedicine cartMedicine = new CartMedicine();
	    cartMedicine.setMedicine(medicine);
	    cartMedicine.setCart(cart);
	    // Set any other required fields
	    
	    // Save the CartMedicine entity to the database
	    CartMedicine createdCartMedicine = cartMedicineService.createCartMedicine(cartMedicine);
	    
	    // Optionally, update the Cart entity with the new CartMedicine
	    
	    return "Item added to Cart!";
	}

	
}

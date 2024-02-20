package com.cdac_project.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdac_project.project.exception.OrderException;
import com.cdac_project.project.model.Address;
import com.cdac_project.project.model.Order;
import com.cdac_project.project.model.Pharmacist;
import com.cdac_project.project.repository.CartRepository;

@Service
public class OrderServiceImplementation implements OrderService{

	private CartRepository cartRepository;
	private CartMedicineService cartMedicineService;
	private MedicineService medicineService;
	public OrderServiceImplementation() {
        // Default constructor
    }
	public OrderServiceImplementation(CartRepository cartRepository, CartMedicineService cartMedicineService,
			MedicineService medicineService) {
		super();
		this.cartRepository = cartRepository;
		this.cartMedicineService = cartMedicineService;
		this.medicineService = medicineService;
	}
	// Constructor injection
    public OrderServiceImplementation(CartMedicineService cartMedicineService) {
        this.cartMedicineService = cartMedicineService;
    }
	@Override
	public Order createOrder(Pharmacist user, Address shippingAdress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderByld(int orderld) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> pharmacistOrdersHistory(int pharmacistld) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order placedOrder(int orderld) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order confirmedOrder(int orderld) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order shippedOrder(int orderld) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deliveredOrder(int orderld) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order cancledOrder(int orderld) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(int Order_ID) throws OrderException {
		// TODO Auto-generated method stub
		
	}

}

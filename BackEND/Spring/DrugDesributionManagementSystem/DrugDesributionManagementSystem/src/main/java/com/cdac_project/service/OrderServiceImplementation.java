package com.cdac_project.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac_project.exception.OrderException;
import com.cdac_project.model.Address;
import com.cdac_project.model.Order;
import com.cdac_project.model.OrderStatus;
import com.cdac_project.model.Pharmacist;
import com.cdac_project.repository.CartRepository;
import com.cdac_project.repository.OrderRepository;

@Service
public class OrderServiceImplementation implements OrderService{

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartMedicineService cartMedicineService;
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private OrderRepository orderRepository;
	
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
        Order order = new Order();
        order.setPharmacist(user);
        order.setShippingAddress(shippingAdress);
        order.setOrderDate(LocalDateTime.now());
        // Set other necessary fields
        return orderRepository.save(order);
	}

	@Override
	public Order findOrderByld(int orderId) throws OrderException {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderException("Order not found with ID: " + orderId));
	}

	@Override
	public List<Order> pharmacistOrdersHistory(int pharmacistld) {

        return orderRepository.findByPharmacistId(pharmacistld);
	}

	@Override
    @Transactional
	public Order placedOrder(int orderId) throws OrderException {
		 Order order = findOrderByld(orderId);
	        if (order == null) {
	            throw new OrderException("Order not found with ID: " + orderId);
	        }
	        order.setStatus(OrderStatus.PLACED);
	        // Perform any other necessary operations
	        return order;
	}

	@Override
    @Transactional
	public Order confirmedOrder(int orderId) throws OrderException {
		 Order order = findOrderByld(orderId);
	        if (order == null) {
	            throw new OrderException("Order not found with ID: " + orderId);
	        }
	        order.setStatus(OrderStatus.CONFIRMED);
	        // Perform any other necessary operations
	        return order;
	}

	@Override
    @Transactional
	public Order shippedOrder(int orderId) throws OrderException {
		// TODO Auto-generated method stub
		 Order order = findOrderByld(orderId);
	        if (order == null) {
	            throw new OrderException("Order not found with ID: " + orderId);
	        }
	        order.setStatus(OrderStatus.SHIPPED);
	        // Set delivery date, if applicable
	        // order.setDeliveryDate(LocalDateTime.now());
	        // Perform any other necessary operations
	        return order;
	}

	@Override
    @Transactional
	public Order deliveredOrder(int orderId) throws OrderException {
		 Order order = findOrderByld(orderId);
	        if (order == null) {
	            throw new OrderException("Order not found with ID: " + orderId);
	        }
	        order.setStatus(OrderStatus.DELIVERED);
	        // Set delivery date, if applicable
	        // order.setDeliveryDate(LocalDateTime.now());
	        // Perform any other necessary operations
	        return order;
	}

	@Override
    @Transactional
	public Order cancledOrder(int orderId) throws OrderException {
		 Order order = findOrderByld(orderId);
	        if (order == null) {
	            throw new OrderException("Order not found with ID: " + orderId);
	        }
	        order.setStatus(OrderStatus.CANCELED);
	        // Perform any other necessary operations
	        return order;
	}

	@Override
	public List<Order> getAllOrders() throws OrderException {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public void deleteOrder(int Order_ID) throws OrderException {
		// TODO Auto-generated method stub
		Optional<Order> optionalOrder = orderRepository.findById(Order_ID);
	    if (optionalOrder.isPresent()) {
	        orderRepository.deleteById(Order_ID);
	    } else {
	        throw new OrderException("Order not found with ID: " + Order_ID);
	    }
	}
	
	@Override
	public Order updateOrder(int orderId, Order updatedOrder) throws OrderException {
	    Optional<Order> optionalOrder = orderRepository.findById(orderId);
	    if (optionalOrder.isPresent()) {
	        Order existingOrder = optionalOrder.get();
	        // Update fields of existingOrder with corresponding fields from updatedOrder
	        // For example:
	        existingOrder.setPrice(updatedOrder.getPrice());
	        existingOrder.setOrderDate(updatedOrder.getOrderDate());
	        // Similarly, update other fields as needed
	        
	        return orderRepository.save(existingOrder);
	    } else {
	        throw new OrderException("Order not found with ID: " + orderId);
	    }
	}


}

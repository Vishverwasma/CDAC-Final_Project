package com.cdac_project.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdac_project.project.exception.OrderException;
import com.cdac_project.project.model.Address;
import com.cdac_project.project.model.Order;
import com.cdac_project.project.model.Pharmacist;

@Service
public interface OrderService {

	public Order createOrder(Pharmacist user, Address shippingAdress);//User
	public Order findOrderByld (Long orderld) throws OrderException;//User
	public List<Order> pharmacistOrdersHistory (Long pharmacistld);//Dist and User
	public Order placedOrder(Long orderld) throws OrderException;//User
	public Order confirmedOrder(Long orderld) throws OrderException;//Dist
	public Order shippedOrder(Long orderld) throws OrderException;//Dist
	public Order deliveredOrder(Long orderld) throws OrderException;//Dist
	public Order cancledOrder(Long orderld) throws OrderException;//Dist and User
	public List<Order> getAllOrders() throws OrderException;//User and Dist
	public void deleteOrder(Long Order_ID) throws OrderException;//User
}

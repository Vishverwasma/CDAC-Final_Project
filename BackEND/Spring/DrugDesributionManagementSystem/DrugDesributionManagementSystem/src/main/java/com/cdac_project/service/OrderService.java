package com.cdac_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdac_project.exception.OrderException;
import com.cdac_project.model.Address;
import com.cdac_project.model.Order;
import com.cdac_project.model.Pharmacist;

@Service
public interface OrderService {

	public Order createOrder(Pharmacist user, Address shippingAdress);//User
	public Order findOrderByld (int orderld) throws OrderException;//User
	public List<Order> pharmacistOrdersHistory (int pharmacistld);//Dist and User
	public Order placedOrder(int orderld) throws OrderException;//User
	public Order confirmedOrder(int orderld) throws OrderException;//Dist
	public Order shippedOrder(int orderld) throws OrderException;//Dist
	public Order deliveredOrder(int orderld) throws OrderException;//Dist
	public Order cancledOrder(int orderld) throws OrderException;//Dist and User
	public List<Order> getAllOrders() throws OrderException;//User and Dist
	public void deleteOrder(int Order_ID) throws OrderException;//User
}

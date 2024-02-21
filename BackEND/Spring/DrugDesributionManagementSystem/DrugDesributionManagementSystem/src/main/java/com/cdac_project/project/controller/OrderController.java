package com.cdac_project.project.controller;

import com.cdac_project.project.exception.OrderException;
import com.cdac_project.project.model.Address;
import com.cdac_project.project.model.Order;
import com.cdac_project.project.model.Pharmacist;
import com.cdac_project.project.service.CartService;
import com.cdac_project.project.service.OrderService;
import com.cdac_project.project.service.PharmacistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private PharmacistService userService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Pharmacist user, @RequestBody Address address) throws OrderException {
        Order createdOrder = orderService.createOrder(user, address);
		return ResponseEntity.ok("Order created successfully with ID: " + createdOrder.getId());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable int orderId) {
        try {
            Order order = orderService.findOrderByld(orderId);
            return ResponseEntity.ok(order);
        } catch (OrderException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/pharmacist/{pharmacistId}")
    public ResponseEntity<?> getPharmacistOrders(@PathVariable int pharmacistId) {
        List<Order> orders = orderService.pharmacistOrdersHistory(pharmacistId);
        return ResponseEntity.ok(orders);
    }

    // Implementation of other endpoints are Fututre Scope : By Vishwas
}

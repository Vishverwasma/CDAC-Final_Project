package com.cdac_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cdac_project.exception.OrderException;
import com.cdac_project.model.Address;
import com.cdac_project.model.Order;
import com.cdac_project.model.Pharmacist;
import com.cdac_project.service.CartService;
import com.cdac_project.service.OrderService;
import com.cdac_project.service.PharmacistService;

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

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders() {
        try {
            List<Order> orders = orderService.getAllOrders();
            return ResponseEntity.ok(orders);
        } catch (OrderException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve orders: " + e.getMessage());
        }
    }
    
    @PutMapping("/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable int orderId, @RequestBody Order updatedOrder) {
        try {
            Order order = orderService.updateOrder(orderId, updatedOrder);
            return ResponseEntity.ok(order);
        } catch (OrderException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update order: " + e.getMessage());
        }
    }

    
    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable int orderId) {
        try {
            orderService.deleteOrder(orderId);
            return ResponseEntity.ok("Order deleted successfully");
        } catch (OrderException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete order: " + e.getMessage());
        }
    }
 // Mapping to place an order
    @PostMapping("/place/{orderId}")
    public ResponseEntity<?> placeOrder(@PathVariable int orderId) {
        try {
            Order placedOrder = orderService.placedOrder(orderId);
            return ResponseEntity.ok("Order placed successfully with ID: " + placedOrder.getId());
        } catch (OrderException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to place order: " + e.getMessage());
        }
    }
 
 // Mapping to confirm an order
    @PutMapping("/confirm/{orderId}")
    public ResponseEntity<?> confirmOrder(@PathVariable int orderId) {
        try {
            Order confirmedOrder = orderService.confirmedOrder(orderId);
            return ResponseEntity.ok("Order confirmed successfully with ID: " + confirmedOrder.getId());
        } catch (OrderException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to confirm order: " + e.getMessage());
        }
    }

 // Mapping to ship an order
    @PutMapping("/ship/{orderId}")
    public ResponseEntity<?> shipOrder(@PathVariable int orderId) {
        try {
            Order shippedOrder = orderService.shippedOrder(orderId);
            return ResponseEntity.ok("Order shipped successfully with ID: " + shippedOrder.getId());
        } catch (OrderException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to ship order: " + e.getMessage());
        }
    }
    
    // Mapping to cancel an order
    @PutMapping("/cancel/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable int orderId) {
        try {
            Order cancelledOrder = orderService.cancledOrder(orderId);
            return ResponseEntity.ok("Order cancelled successfully with ID: " + cancelledOrder.getId());
        } catch (OrderException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to cancel order: " + e.getMessage());
        }
    }
}

package com.cdac_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cdac_project.exception.CartException;
import com.cdac_project.exception.CartIsEmptyExcetpion;
import com.cdac_project.exception.CartMedicineException;
import com.cdac_project.exception.MedicineException;
import com.cdac_project.exception.PharmacistException;
import com.cdac_project.model.Cart;
import com.cdac_project.request.AddMedicineRequest;
import com.cdac_project.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/create/{pharmacistId}")
    public ResponseEntity<String> createCart(@PathVariable int pharmacistId) throws PharmacistException {
    	System.out.println("In Add of Create Cart Method");
        Cart createdCart = cartService.createCart(pharmacistId);
        return ResponseEntity.ok("Cart created successfully with ID: " + createdCart.getId());
    }

    @PostMapping("/addMedicine/{pharmacistId}")
    public ResponseEntity<String> addMedicineToCart(@RequestBody AddMedicineRequest request) {
    	System.out.println("In Adding medicine of Create Cart Method");
        try {
            String message = cartService.addCartMedicine(request.getpID(), request.getQuantity());
            return ResponseEntity.ok(message);
        } catch (MedicineException | CartException | CartMedicineException | PharmacistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/get/{pharmacistId}")
    public ResponseEntity<Cart> getCartByPharmacistId(@PathVariable int pharmacistId) throws PharmacistException, CartException {
    	System.out.println("In get of Create Cart Method by Pharmacist ID");
        Cart cart = cartService.findPharmacistCart(pharmacistId);
        return ResponseEntity.ok(cart);
    }
    @GetMapping("/clear/{pharmacistId}")
    public ResponseEntity<String> clearCart(@PathVariable int pharmacistId) throws CartException, PharmacistException {
        cartService.clearCart(pharmacistId);
		return ResponseEntity.ok("Cart cleared successfully");
    }
}

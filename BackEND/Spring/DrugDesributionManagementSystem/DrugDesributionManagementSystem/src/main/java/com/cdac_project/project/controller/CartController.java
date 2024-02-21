package com.cdac_project.project.controller;

import com.cdac_project.project.exception.CartException;
import com.cdac_project.project.exception.CartMedicineException;
import com.cdac_project.project.exception.MedicineException;
import com.cdac_project.project.exception.PharmacistException;
import com.cdac_project.project.model.Cart;
import com.cdac_project.project.request.AddMedicineRequest;
import com.cdac_project.project.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Cart createdCart = cartService.createCart(pharmacistId);
        return ResponseEntity.ok("Cart created successfully with ID: " + createdCart.getId());
    }

    @PostMapping("/addMedicine")
    public ResponseEntity<String> addMedicineToCart(@RequestBody AddMedicineRequest request) {
        try {
            String message = cartService.addCartMedicine(request.getpID(), request.getQuantity());
            return ResponseEntity.ok(message);
        } catch (MedicineException | CartException | CartMedicineException | PharmacistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{pharmacistId}")
    public ResponseEntity<Cart> getCartByPharmacistId(@PathVariable int pharmacistId) throws PharmacistException {
        Cart cart = cartService.findPharmacistCart(pharmacistId);
        return ResponseEntity.ok(cart);
    }
}

package com.cdac_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cdac_project.exception.CartMedicineException;
import com.cdac_project.exception.PharmacistException;
import com.cdac_project.model.CartMedicine;
import com.cdac_project.request.CreateMedicineRequest;
import com.cdac_project.service.CartMedicineService;

@RestController
@RequestMapping("/cart/medicine")
//@CrossOrigin(origins = "http://localhost:3000")
public class CartMedicineController {

    private final CartMedicineService cartMedicineService;

    public CartMedicineController(CartMedicineService cartMedicineService) {
        this.cartMedicineService = cartMedicineService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCartMedicine(@RequestBody CreateMedicineRequest request) throws PharmacistException {
    	System.out.println("In Creat method of CartMedicine");
        try {
            CartMedicine cartMedicine = convertRequestToCartMedicine(request);
            CartMedicine createdMedicine = cartMedicineService.createCartMedicine(cartMedicine);
            return ResponseEntity.ok("Cart Medicine created successfully");
        } catch (CartMedicineException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{pharmacistId}/{medsId}")
    public ResponseEntity<?> updateCartMedicine(@PathVariable int pharmacistId,
                                                 @PathVariable int medsId,
                                                 @RequestBody CartMedicine cartMedicine) throws PharmacistException {
    	System.out.println("In getting 1 method of CartMedicine");
        try {
            CartMedicine updatedMedicine = cartMedicineService.updateCartMedicine(pharmacistId, medsId, cartMedicine);
            return ResponseEntity.ok("Cart Medicine updated successfully");
        } catch (CartMedicineException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{pharmacistId}/{medsId}")
    public ResponseEntity<?> removeCartMedicine(@PathVariable int pharmacistId,
                                                 @PathVariable int medsId) throws PharmacistException {
    	System.out.println("In getting 2 method of CartMedicine");
        try {
            cartMedicineService.removeCartMedicine(pharmacistId, medsId);
            return ResponseEntity.ok("Cart Medicine removed successfully");
        } catch (CartMedicineException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    private CartMedicine convertRequestToCartMedicine(CreateMedicineRequest request) {
        CartMedicine cartMedicine = new CartMedicine();
        // You need to set properties of CartMedicine from the request object
        // For example: cartMedicine.setMedicinename(request.getMedicinename());
        return cartMedicine;
    }
}

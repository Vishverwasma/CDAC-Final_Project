package com.cdac_project.project.controller;

import com.cdac_project.project.exception.CartMedicineException;
import com.cdac_project.project.exception.PharmacistException;
import com.cdac_project.project.model.CartMedicine;
import com.cdac_project.project.request.CreateMedicineRequest;
import com.cdac_project.project.service.CartMedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart/medicine")
public class CartMedicineController {

    private final CartMedicineService cartMedicineService;

    public CartMedicineController(CartMedicineService cartMedicineService) {
        this.cartMedicineService = cartMedicineService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCartMedicine(@RequestBody CreateMedicineRequest request) throws PharmacistException {
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

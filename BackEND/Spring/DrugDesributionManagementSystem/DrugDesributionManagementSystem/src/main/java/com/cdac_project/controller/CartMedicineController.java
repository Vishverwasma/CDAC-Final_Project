package com.cdac_project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cdac_project.exception.CartMedicineException;
import com.cdac_project.exception.PharmacistException;
import com.cdac_project.model.CartMedicine;
import com.cdac_project.model.Medicine;
import com.cdac_project.model.Pharmacist;
import com.cdac_project.request.CreateMedicineRequest;
import com.cdac_project.service.CartMedicineService;
import com.cdac_project.service.MedicineService;
import com.cdac_project.service.PharmacistService;

@RestController
@RequestMapping("/cart/medicine")
@CrossOrigin(origins = "http://localhost:3000")
public class CartMedicineController {

    @Autowired
    private final CartMedicineService cartMedicineService;
    @Autowired
    private final MedicineService medicineService; 
    @Autowired
    private PharmacistService pharmacistService;

    public CartMedicineController(CartMedicineService cartMedicineService,MedicineService medicineService) {
        this.cartMedicineService = cartMedicineService;
		this.medicineService = medicineService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createCartMedicine(@RequestBody CreateMedicineRequest request) {
        try {
            if (request == null || request.getMedicineId() <= 0 || request.getPharmacistId() <= 0 || request.getMedicineQuantity() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input request");
            }
            
            Pharmacist pharmacist = pharmacistService.findPharmacistById(request.getPharmacistId());
            if (pharmacist == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pharmacist not found with ID: " + request.getPharmacistId());
            }

            Optional<Medicine> optionalMedicine = medicineService.findById(request.getMedicineId());
            if (!optionalMedicine.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Medicine not found with ID: " + request.getMedicineId());
            }

            Medicine medicine = optionalMedicine.get();
            CartMedicine cartMedicine = new CartMedicine();
            cartMedicine.setPharmacistId(request.getPharmacistId());
            cartMedicine.setQuantity(request.getMedicineQuantity());
            cartMedicine.setMedicine(medicine);
            cartMedicine.setPrice(request.getMedicineQuantity() * medicine.getUnitPrice());

            CartMedicine createdMedicine = cartMedicineService.createCartMedicine(cartMedicine);
            return ResponseEntity.ok("Cart Medicine created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } 
    }



    @PutMapping("/put/{pharmacistId}/{medsId}")
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

    @DeleteMapping("/del/{pharmacistId}/{medsId}")
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

    private CartMedicine convertRequestToCartMedicine(CreateMedicineRequest request) throws CartMedicineException {
    	CartMedicine cartMedicine = new CartMedicine();
        cartMedicine.setPharmacistId(request.getPharmacistId());
        cartMedicine.setQuantity(request.getMedicineQuantity());

        // Fetch the Medicine object from the database based on the provided medicineId
        Optional<Medicine> optionalMedicine = medicineService.findById(request.getMedicineId());
        if (optionalMedicine.isPresent()) {
        	Medicine medicine = optionalMedicine.get();
            cartMedicine.setMedicine(medicine);
            // Calculate and set the price based on the quantity and unit price of the medicine
            cartMedicine.setPrice(request.getMedicineQuantity() * medicine.getUnitPrice());
        } else {
            throw new CartMedicineException("Medicine with ID " + request.getMedicineId() + " not found");
        }
		return cartMedicine;
    }
}

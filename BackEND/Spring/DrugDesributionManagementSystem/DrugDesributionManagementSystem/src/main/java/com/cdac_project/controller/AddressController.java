package com.cdac_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cdac_project.exception.AddressNotFoundException;
import com.cdac_project.model.Address;
import com.cdac_project.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {

	@Autowired
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
    	System.out.println("In Add Address Method");
        Address savedAddress = addressService.addAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable int addressId) {
    	System.out.println("In get Address Method");
        try {
            Address address = addressService.getAddressById(addressId);
            return ResponseEntity.ok(address);
        } catch (AddressNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/pharmacist/{pharmacistId}")
    public ResponseEntity<List<Address>> getAddressesByPharmacistId(@PathVariable int pharmacistId) {
    	System.out.println("In get Address Method by id");
        List<Address> addresses = addressService.getAddressesByPharmacistid(pharmacistId);
        return ResponseEntity.ok(addresses);
    }

    @PutMapping("/update/{addressId}")
    public ResponseEntity<Address> updateAddress(@PathVariable int addressId, @RequestBody Address address) {
    	System.out.println("In Update Address Method");
        try {
            Address updatedAddress = addressService.updateAddress(addressId, address);
            return ResponseEntity.ok(updatedAddress);
        } catch (AddressNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable int addressId) {
    	System.out.println("In delete Address Method");
        try {
            addressService.deleteAddress(addressId);
            return ResponseEntity.ok("Address deleted successfully");
        } catch (AddressNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

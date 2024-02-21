package com.cdac_project.project.controller;

import com.cdac_project.project.exception.AddressNotFoundException;
import com.cdac_project.project.model.Address;
import com.cdac_project.project.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        Address savedAddress = addressService.addAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddressById(@PathVariable int addressId) {
        try {
            Address address = addressService.getAddressById(addressId);
            return ResponseEntity.ok(address);
        } catch (AddressNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/pharmacist/{pharmacistId}")
    public ResponseEntity<List<Address>> getAddressesByPharmacistId(@PathVariable int pharmacistId) {
        List<Address> addresses = addressService.getAddressesByPharmacistId(pharmacistId);
        return ResponseEntity.ok(addresses);
    }

    @PutMapping("/update/{addressId}")
    public ResponseEntity<Address> updateAddress(@PathVariable int addressId, @RequestBody Address address) {
        try {
            Address updatedAddress = addressService.updateAddress(addressId, address);
            return ResponseEntity.ok(updatedAddress);
        } catch (AddressNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable int addressId) {
        try {
            addressService.deleteAddress(addressId);
            return ResponseEntity.ok("Address deleted successfully");
        } catch (AddressNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

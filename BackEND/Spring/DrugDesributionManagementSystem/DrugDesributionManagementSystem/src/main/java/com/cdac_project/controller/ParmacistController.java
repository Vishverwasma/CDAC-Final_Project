package com.cdac_project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.cdac_project.exception.PharmacistException;
import com.cdac_project.model.Pharmacist;
import com.cdac_project.repository.PharmacistRepository;
import com.cdac_project.request.ChangePasswordRequest;
import com.cdac_project.request.LoginRequest;
import com.cdac_project.response.AuthResponse;
import com.cdac_project.service.CustomPharmacistServiceImplementation;
import com.cdac_project.service.PharmacistService;
import com.cdac_project.service.PharmacistServiceImplementation;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/pharmacist")
public class ParmacistController {

	@Autowired
    private PharmacistRepository pharmacistRepository;
    @Autowired
    private PharmacistService pharmacistService;
    @Autowired
    private PharmacistServiceImplementation pharmacistServiceImplementation;
    @Autowired
    private CustomPharmacistServiceImplementation customPharmacistService;

    public ParmacistController(PharmacistRepository pharmacistRepository, CustomPharmacistServiceImplementation customPharmacistService) {
        this.pharmacistRepository = pharmacistRepository;
        this.customPharmacistService = customPharmacistService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody Pharmacist pharmacist) throws PharmacistException {

    	System.out.println("In Sign-Up Method of Pharmacist");
    	
        String name = pharmacist.getName();
        String License_Number = pharmacist.getLicenseNumber();
        String email = pharmacist.getEmail();
        String Address = pharmacist.getAddress();
        String password = pharmacist.getPassword();

        Pharmacist isEmailExist = pharmacistRepository.findByEmail(email);
        if (isEmailExist != null) {
            throw new PharmacistException("Email is Already in Use with Another Account! ");
        }
        Pharmacist createdPharmacist = new Pharmacist();
        createdPharmacist.setName(name);
        createdPharmacist.setLicenseNumber(License_Number);
        createdPharmacist.setEmail(email);
        createdPharmacist.setAddress(Address);
        createdPharmacist.setPassword(password);

        Pharmacist savedPharmacist = pharmacistRepository.save(createdPharmacist);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setMessage("Sign-Up Success");

        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public Pharmacist login(@RequestBody LoginRequest request) {
        return pharmacistServiceImplementation.authenticate(request.getEmail(), request.getPassword());
    }
    @GetMapping("/get-user/{email}")
    public Pharmacist getPharmacist(@PathVariable("email") String email) throws PharmacistException {
    	return pharmacistService.findPharmacistByEmailId(email);
    }
    
    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
    	return ResponseEntity.ok("Logout successful");
    }
    
    @PutMapping("/change-password/{email}")
    public ResponseEntity<String> changePassword(@PathVariable("email") String email, @RequestBody ChangePasswordRequest request) {
    	 try {
    	        Pharmacist pharmacist = pharmacistRepository.findByEmail(email);
    	        if (pharmacist == null) {
    	            throw new PharmacistException("Pharmacist not found with email: " + email);
    	        }

    	        // Check if the provided license number matches the pharmacist's license number
    	        if (!pharmacist.getLicenseNumber().equals(request.getLicenseNumber())) {
    	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect license number");
    	        }

    	        boolean passwordChanged = pharmacistService.changePassword(pharmacist, request.getNewPassword());
    	        if (passwordChanged) {
    	            return ResponseEntity.ok("Password changed successfully");
    	        } else {
    	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect old password");
    	        }
    	    } catch (PharmacistException e) {
    	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	    }
    }
}

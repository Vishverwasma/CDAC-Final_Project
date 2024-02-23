package com.cdac_project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.cdac_project.exception.PharmacistException;
import com.cdac_project.model.Pharmacist;
import com.cdac_project.repository.PharmacistRepository;
import com.cdac_project.request.LoginRequest;
import com.cdac_project.response.AuthResponse;
import com.cdac_project.service.CustomPharmacistServiceImplementation;
import com.cdac_project.service.PharmacistServiceImplementation;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/pharmacist")
public class ParmacistController {

	@Autowired
    private PharmacistRepository pharmacistRepository;
    @Autowired
    private PharmacistServiceImplementation pharmacistService;
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
        return pharmacistService.authenticate(request.getEmail(), request.getPassword());
    }
    
}

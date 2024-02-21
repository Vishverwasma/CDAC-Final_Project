package com.cdac_project.project.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.cdac_project.project.exception.PharmacistException;
import com.cdac_project.project.model.Address;
import com.cdac_project.project.model.Pharmacist;
import com.cdac_project.project.repository.PharmacistRepository;
import com.cdac_project.project.request.LoginRequest;
import com.cdac_project.project.response.AuthResponse;
import com.cdac_project.project.service.CustomPharmacistServiceImplementation;

@RestController
@RequestMapping("/pharmacist")
public class ParmacistController {

	@Autowired
    private PharmacistRepository pharmacistRepository;
    @Autowired
    private CustomPharmacistServiceImplementation customPharmacistService;

    public ParmacistController(PharmacistRepository pharmacistRepository, CustomPharmacistServiceImplementation customPharmacistService) {
        this.pharmacistRepository = pharmacistRepository;
        this.customPharmacistService = customPharmacistService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody Pharmacist pharmacist) throws PharmacistException {

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

    @PostMapping("/signin")
    public ResponseEntity<String> login(@RequestBody LoginRequest lr) {

        String username = lr.getEmail();
        String password = lr.getPassoword();
        UserDetails userDetails = customPharmacistService.loadUserByUsername(username);
        if (userDetails == null || !password.equals(userDetails.getPassword())) {
            throw new BadCredentialsException("In-Valid Credentials!");
        }
        AuthResponse authResponse = new AuthResponse();
        authResponse.setMessage("Sign-In Success");

        return new ResponseEntity(HttpStatus.OK);
    }

}
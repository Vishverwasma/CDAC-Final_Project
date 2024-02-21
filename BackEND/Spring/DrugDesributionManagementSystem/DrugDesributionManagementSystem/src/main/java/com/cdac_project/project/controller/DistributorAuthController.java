package com.cdac_project.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac_project.project.exception.DistributorException;
import com.cdac_project.project.model.Distributor;
import com.cdac_project.project.repository.DistributorRepository;
import com.cdac_project.project.request.LoginRequest;
import com.cdac_project.project.response.AuthResponse;
import com.cdac_project.project.service.CustomDistributorServiceImplementation;

@RestController
@RequestMapping("/distributor")
public class DistributorAuthController {

    private DistributorRepository distributorRepository;
	    private CustomDistributorServiceImplementation customDistributorService;

	    public DistributorAuthController(DistributorRepository distributorRepository, CustomDistributorServiceImplementation customDistributorService) {
	        this.distributorRepository = distributorRepository;
	        this.customDistributorService = customDistributorService;
	    }

	    @PostMapping("/signup")
	    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody Distributor distributor) throws DistributorException{

        String email = distributor.getEmail();
        String name = distributor.getName();
        String password = distributor.getPassword();

        Distributor isEmailExist = distributorRepository.findByEmail(email);
        if (isEmailExist != null) {
            throw new DistributorException("Email is Already in Use with Another Account! ");
        }
        Distributor createdDistributor = new Distributor();
        createdDistributor.setEmail(email);
        createdDistributor.setName(name);
        createdDistributor.setPassword(password);

        Distributor savedDistributor = distributorRepository.save(createdDistributor);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setMessage("Sign-Up Success");

        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest) {

        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        UserDetails userDetails = customDistributorService.loadUserByUsername(username);
        if (userDetails == null) {
            throw new BadCredentialsException("Invalid Username");
        }
        AuthResponse authResponse = new AuthResponse();
        authResponse.setMessage("Sign-In Success");

        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
    }
}

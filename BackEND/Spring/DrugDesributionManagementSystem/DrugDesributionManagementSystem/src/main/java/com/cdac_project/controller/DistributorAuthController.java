package com.cdac_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac_project.exception.DistributorException;
import com.cdac_project.model.Distributor;
import com.cdac_project.repository.DistributorRepository;
import com.cdac_project.request.LoginRequest;
import com.cdac_project.response.AuthResponse;
import com.cdac_project.service.CustomDistributorServiceImplementation;
import com.cdac_project.service.DistributionServiceImplementation;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/distributor")
public class DistributorAuthController {

	@Autowired
    private DistributorRepository distributorRepository;
	@Autowired
	private CustomDistributorServiceImplementation customDistributorService;
	@Autowired
	private DistributionServiceImplementation distributorService;

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

	         return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }


	    @PostMapping("/login")
	    public Distributor login(@RequestBody LoginRequest request) {
	        return distributorService.authenticate(request.getEmail(), request.getPassword());
	    }
}

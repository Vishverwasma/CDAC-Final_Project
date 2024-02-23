package com.cdac_project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac_project.exception.DistributorException;
import com.cdac_project.model.Distributor;
import com.cdac_project.repository.DistributorRepository;
import com.cdac_project.request.LoginRequest;

@Service
public class DistributionServiceImplementation implements DistributorService {

	@Autowired
	private DistributorRepository distributorRepository;
	
	
	public DistributionServiceImplementation() {
		super();
	}

	public DistributionServiceImplementation(DistributorRepository distributorRepository) {
		super();
		this.distributorRepository = distributorRepository;
	}

	@Override
	public Distributor findDistributorById(int Distributor_ID) throws DistributorException {
		// TODO Auto-generated method stub

		Optional<Distributor> distributor = distributorRepository.findById(Distributor_ID);
		if(distributor.isPresent()) {
			return distributor.get();
		}
		throw new DistributorException("Distributor Not Found With ID : "+Distributor_ID);
	
	}
	@Override
	public Distributor addDistributor(Distributor d) throws DistributorException {
		// TODO Auto-generated method stub
		return distributorRepository.save(d);
	}

	@Override
	public boolean login(LoginRequest login) {
		Distributor p = distributorRepository.findByEmail(login.getEmail());
		return p != null && validatePassword(login.getPassword(), p.getPassword());
	    }

	@Override
	public Distributor authenticate(String Email, String password) {
		// TODO Auto-generated method stub
		Distributor user = distributorRepository.findByEmail(Email);
        if (user != null && validatePassword(password, user.getPassword())) {
            return user;
        }
        return null;
	}
	 private boolean validatePassword(String inputPassword, String storedPassword) {
	        return inputPassword.equals(storedPassword);
	}

}

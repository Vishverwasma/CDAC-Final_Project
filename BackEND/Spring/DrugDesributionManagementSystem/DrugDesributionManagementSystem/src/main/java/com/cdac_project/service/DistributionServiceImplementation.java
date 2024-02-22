package com.cdac_project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdac_project.exception.DistributorException;
import com.cdac_project.model.Distributor;
import com.cdac_project.model.Pharmacist;
import com.cdac_project.repository.DistributorRepository;
import com.cdac_project.request.LoginRequest;

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
	    if (p != null && login.getPassword().equals(p.getPassword())) {
	        return true;
	    }
	    return false;
	}

}

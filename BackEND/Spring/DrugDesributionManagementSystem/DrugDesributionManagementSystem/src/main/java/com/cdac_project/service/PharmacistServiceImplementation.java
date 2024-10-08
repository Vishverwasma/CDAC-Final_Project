package com.cdac_project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac_project.exception.PharmacistException;
import com.cdac_project.model.Pharmacist;
import com.cdac_project.repository.PharmacistRepository;
import com.cdac_project.request.LoginRequest;

@Service
public class PharmacistServiceImplementation implements PharmacistService{

	@Autowired
	private PharmacistRepository pharmacistRepository;
		
	public PharmacistServiceImplementation() {
		super();
	}

	public PharmacistServiceImplementation(PharmacistRepository pharmacistRepository) {
		super();
		this.pharmacistRepository = pharmacistRepository;
	}

	
	
	@Override
	public Pharmacist findPharmacistById(int Id) throws PharmacistException {
		// TODO Auto-generated method stub
		
		Optional<Pharmacist> pharmacist = pharmacistRepository.findById(Id);
		if(pharmacist.isPresent()) {
			return pharmacist.get();
		}
		throw new PharmacistException("Pharmacist Not Found With ID : "+Id);
	}
    //trial : For Get By Email
	@Override
	public Pharmacist findPharmacistByEmailId(String email) throws PharmacistException {
		// TODO Auto-generated method stub
		Pharmacist pharmacist = pharmacistRepository.findByEmail(email);
			return pharmacist;
			}


	@Override
	public Pharmacist addPharmacist(Pharmacist p) throws PharmacistException {
		// TODO Auto-generated method stub
		return pharmacistRepository.save(p);
	}

	@Override
	public boolean login(LoginRequest login) {
	    Pharmacist p = pharmacistRepository.findByEmail(login.getEmail());
	    if (p != null && login.getPassword().equals(p.getPassword())) {
	        return true;
	    }
	    return false;
	}

	@Override
	public Pharmacist authenticate(String Email, String password) {
		// TODO Auto-generated method stub
		Pharmacist user = pharmacistRepository.findByEmail(Email);
        if (user != null && validatePassword(password, user.getPassword())) {
            return user;
        }
        return null;
	}
	 private boolean validatePassword(String inputPassword, String storedPassword) {
	        return inputPassword.equals(storedPassword);
	    }

	@Override
	public boolean changePassword(Pharmacist pharmacist, String newPassword) {
		// TODO Auto-generated method stub
		 if (newPassword != null) {
	            pharmacist.setPassword(newPassword);
	            return true;
	        } else {
	            return false;
	        }
	}


}

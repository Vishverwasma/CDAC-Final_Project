
package com.cdac_project.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cdac_project.exception.DistributorException;
import com.cdac_project.model.Distributor;
import com.cdac_project.repository.DistributorRepository;
import com.cdac_project.request.LoginRequest;

@Service
public class CustomDistributorServiceImplementation implements DistributorService{
	@Autowired
	private DistributorRepository distributorRepository;

	public CustomDistributorServiceImplementation(DistributorRepository distributorRepository)throws DistributorException{
		this.distributorRepository=distributorRepository;
	}

	@Override
	public Distributor findDistributorById(int Distributor_ID) throws DistributorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Distributor addDistributor(Distributor d) throws DistributorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(LoginRequest login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Distributor authenticate(String Email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		
//		Distributor distributor=distributorRepository.findByEmail(username);
//		if(distributor==null) {
//			throw new DistributorException("User with email -"+username+" not Found! ");
//		}
//		List<GrantedAuthority> authorities =new ArrayList<>();
//		return new org.springframework.security.core.userdetails.User(distributor.getEmail(),distributor.getPassword(),authorities);
//	}
	
	
}
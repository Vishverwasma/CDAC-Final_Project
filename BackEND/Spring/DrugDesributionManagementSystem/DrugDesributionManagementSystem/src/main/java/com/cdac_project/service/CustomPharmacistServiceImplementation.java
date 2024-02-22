package com.cdac_project.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cdac_project.model.Pharmacist;
import com.cdac_project.repository.PharmacistRepository;

@Service
public class CustomPharmacistServiceImplementation implements UserDetailsService{
    private PharmacistRepository pharmacistRepository;

 // Constructor for dependency injection
    @Autowired
	public CustomPharmacistServiceImplementation(PharmacistRepository pharmacistRepository){
		this.pharmacistRepository=pharmacistRepository;
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		
//		Pharmacist pharmacist=pharmacistRepository.findByEmail(username);
//		if(pharmacist==null) {
//			throw new UsernameNotFoundException("User with email -"+username+" not Found! ");
//		}
//		List<GrantedAuthority> authorities =new ArrayList<>();
//		return new org.springframework.security.core.userdetails.User(pharmacist.getEmail(),pharmacist.getPassword(),authorities);
//	}
	
	
}

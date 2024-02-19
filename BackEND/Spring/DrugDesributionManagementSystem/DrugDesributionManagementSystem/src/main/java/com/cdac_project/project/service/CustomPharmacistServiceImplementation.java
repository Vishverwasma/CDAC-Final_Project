package com.cdac_project.project.service;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cdac_project.project.model.Pharmacist;
import com.cdac_project.project.repository.PharmacistRepository;

@Service
public class CustomPharmacistServiceImplementation implements UserDetailsService{
    private PharmacistRepository pharmacistRepository;

	//1:30:24

	public CustomPharmacistServiceImplementation(PharmacistRepository pharmacistRepository)throws UsernameNotFoundException{
		this.pharmacistRepository=pharmacistRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Pharmacist pharmacist=pharmacistRepository.findByEmail(username);
		if(pharmacist==null) {
			throw new UsernameNotFoundException("User with email -"+username+" not Found! ");
		}
		List<GrantedAuthority> authorities =new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(pharmacist.getEmail(),pharmacist.getPassword(),authorities);
	}
	
	
}

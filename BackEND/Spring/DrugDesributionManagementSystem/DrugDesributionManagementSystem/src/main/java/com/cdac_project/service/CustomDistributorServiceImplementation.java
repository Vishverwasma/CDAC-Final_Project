
package com.cdac_project.service;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cdac_project.model.Distributor;
import com.cdac_project.repository.DistributorRepository;

@Service
public class CustomDistributorServiceImplementation implements UserDetailsService{
    private DistributorRepository distributorRepository;

	//1:30:24

	public CustomDistributorServiceImplementation(DistributorRepository distributorRepository)throws UsernameNotFoundException{
		this.distributorRepository=distributorRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Distributor distributor=distributorRepository.findByEmail(username);
		if(distributor==null) {
			throw new UsernameNotFoundException("User with email -"+username+" not Found! ");
		}
		List<GrantedAuthority> authorities =new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(distributor.getEmail(),distributor.getPassword(),authorities);
	}
	
	
}
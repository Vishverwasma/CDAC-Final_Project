package com.cdac_project.service;

import org.springframework.stereotype.Service;

import com.cdac_project.exception.DistributorException;
import com.cdac_project.model.Distributor;

@Service
public interface DistributorService{
	public  Distributor findDistributorById(int Distributor_ID)throws DistributorException;
	
	public  Distributor findDistributorProfileByJwt(String jwt)throws DistributorException;
	
}

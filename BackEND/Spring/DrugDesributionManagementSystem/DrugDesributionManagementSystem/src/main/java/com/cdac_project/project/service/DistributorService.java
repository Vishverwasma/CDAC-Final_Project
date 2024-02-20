package com.cdac_project.project.service;

import org.springframework.stereotype.Service;

import com.cdac_project.project.exception.DistributorException;
import com.cdac_project.project.model.Distributor;

@Service
public interface DistributorService{
	public  Distributor findDistributorById(int Distributor_ID)throws DistributorException;
	
	public  Distributor findDistributorProfileByJwt(String jwt)throws DistributorException;
	
}

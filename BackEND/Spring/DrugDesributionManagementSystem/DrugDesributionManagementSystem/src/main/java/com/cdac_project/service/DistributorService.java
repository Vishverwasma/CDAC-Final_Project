package com.cdac_project.service;

import org.springframework.stereotype.Service;

import com.cdac_project.exception.DistributorException;
import com.cdac_project.exception.PharmacistException;
import com.cdac_project.model.Distributor;
import com.cdac_project.model.Pharmacist;
import com.cdac_project.request.LoginRequest;

@Service
public interface DistributorService{
	public  Distributor findDistributorById(int Distributor_ID)throws DistributorException;
	public  Distributor addDistributor(Distributor d)throws DistributorException;
	public boolean login(LoginRequest login);
	public Distributor authenticate(String Email, String password);
}

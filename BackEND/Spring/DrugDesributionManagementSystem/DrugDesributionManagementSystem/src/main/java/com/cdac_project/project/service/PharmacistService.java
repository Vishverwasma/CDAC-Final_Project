package com.cdac_project.project.service;

import org.springframework.stereotype.Service;

import com.cdac_project.project.exception.PharmacistException;
import com.cdac_project.project.model.Pharmacist;
import com.cdac_project.project.request.LoginRequest;

@Service
public interface PharmacistService{
	public  Pharmacist addPharmacist(Pharmacist p)throws PharmacistException;
	public  Pharmacist findPharmacistById(int p_ID)throws PharmacistException;
	public boolean login(LoginRequest login);
	
}

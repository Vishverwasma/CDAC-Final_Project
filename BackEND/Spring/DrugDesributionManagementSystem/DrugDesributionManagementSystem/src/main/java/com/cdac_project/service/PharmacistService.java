package com.cdac_project.service;

import org.springframework.stereotype.Service;

import com.cdac_project.exception.PharmacistException;
import com.cdac_project.model.Pharmacist;
import com.cdac_project.request.LoginRequest;

@Service
public interface PharmacistService{
	public  Pharmacist addPharmacist(Pharmacist p)throws PharmacistException;
	public  Pharmacist findPharmacistById(int p_ID)throws PharmacistException;
	public boolean login(LoginRequest login);
	public Pharmacist authenticate(String Emaail, String password);
}

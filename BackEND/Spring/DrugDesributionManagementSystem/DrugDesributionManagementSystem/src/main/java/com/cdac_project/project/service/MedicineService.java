package com.cdac_project.project.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cdac_project.project.exception.MedicineException;
import com.cdac_project.project.model.Medicine;
import com.cdac_project.project.model.MedicineCategory;
import com.cdac_project.project.model.MedicineSearchCriteria;
import com.cdac_project.project.request.CreateMedicineRequest;

@Service
public interface MedicineService {

	public Medicine createMedicine(CreateMedicineRequest req);
	public String deleteMedcine(Long Medicine_ID)throws MedicineException;
	
	public Medicine updateMedicine(Long Medicine_ID,Medicine req) throws MedicineException;
	public Medicine findMedicineById(Long id) throws MedicineException;
	public List<Medicine> findMedicineByCategoryId(Long Category_id);
	//public Page<Medicine> getAllMedicine(Long Medicineid,String MedicineName ,Long CategoryId ,Long Quantity, LocalDate ManufactureDate , Long UnitPrice) throws MedicineException;
	
	
}

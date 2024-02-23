package com.cdac_project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cdac_project.exception.MedicineException;
import com.cdac_project.model.Medicine;
import com.cdac_project.model.MedicineCategory;
import com.cdac_project.model.MedicineSearchCriteria;
import com.cdac_project.request.CreateMedicineRequest;

@Service
public interface MedicineService {

	public Medicine createMedicine(CreateMedicineRequest req);
	public String deleteMedicine(int Medicine_ID)throws MedicineException;
	public Medicine updateMedicine(int Medicine_ID,Medicine req) throws MedicineException;
	public Medicine findMedicineById(int id) throws MedicineException;
	public List<Medicine> findMedicineByCategory(int Category_id) throws Exception;
	public Page<Medicine> getAllMedicine(int Medicineid,String MedicineName ,int CategoryId ,int Quantity, LocalDate ManufactureDate , int UnitPrice) throws MedicineException;
	public Optional<Medicine> findById(int id);
    public Page<Medicine> searchMedicines(MedicineSearchCriteria criteria);
	public Page<Medicine> getAllMedicines(int page, int size);
}

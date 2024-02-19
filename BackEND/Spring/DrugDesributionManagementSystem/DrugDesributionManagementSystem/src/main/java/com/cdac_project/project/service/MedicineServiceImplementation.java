package com.cdac_project.project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cdac_project.project.exception.MedicineException;
import com.cdac_project.project.model.Medicine;
import com.cdac_project.project.model.MedicineCategory;
import com.cdac_project.project.model.MedicineSearchCriteria;
import com.cdac_project.project.model.Pharmacist;
import com.cdac_project.project.repository.MedicineCategoryRepository;
import com.cdac_project.project.repository.MedicineRepository;
import com.cdac_project.project.repository.PharmacistRepository;
import com.cdac_project.project.request.CreateMedicineRequest;

@Service
public class MedicineServiceImplementation implements MedicineService{

	private MedicineRepository medicineRepository;
	private PharmacistService phramacistService;
	private MedicineCategoryRepository categoryRepository; 	
	
	public MedicineServiceImplementation() {}
	
	
	public MedicineServiceImplementation(MedicineRepository medicineRepository,
			PharmacistService phramacistService, MedicineCategoryRepository categoryRepository) {
		super();
		this.medicineRepository = medicineRepository;
		this.phramacistService = phramacistService;
		this.categoryRepository = categoryRepository;
	}


	@Override
	public Medicine createMedicine(CreateMedicineRequest req) {
		// TODO Auto-generated method stub
		
		MedicineCategory cid = categoryRepository.findByCategoryid(req.getCategoryid());
		if(cid==null) {
		MedicineCategory category = new MedicineCategory();
		category.setCategoryid((long) 1);
		cid=categoryRepository.save(category);	
		}
		
		Medicine medicine=new Medicine();
		medicine.setName(req.getMedicinename());
		medicine.setCategory(cid);
		medicine.setQuantity(req.getMedicineQuantity());
		medicine.setManufactureDate(req.getManufactureDate());
		medicine.setUnitPrice(req.getUnitPrice());
		
		Medicine savedMedicine = medicineRepository.save(medicine);
		return savedMedicine;
	}

	@Override
	public String deleteMedcine(Long Medicine_ID) throws MedicineException {
		// TODO Auto-generated method stub
		
		Medicine medicine= findMedicineById(Medicine_ID);
		
		medicineRepository.delete(medicine);
		
		return "Medicine Deleted SuccessFully ! ";
	}

	@Override
	public Medicine updateMedicine(Long Medicine_ID, Medicine req) throws MedicineException {
		// TODO Auto-generated method stub

		Medicine medicine= findMedicineById(Medicine_ID);
		if(req.getQuantity()!=0) {
			medicine.setQuantity(req.getQuantity());
		}
		return medicineRepository.save(medicine);
	}

	@Override
	public Medicine findMedicineById(Long Medicine_ID) throws MedicineException {
		// TODO Auto-generated method stub
		Optional<Medicine> opt = medicineRepository.findById(Medicine_ID);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new MedicineException("Medicine not Found with ID : "+Medicine_ID);
	}


	@Override
	public List<Medicine> findMedicineByCategoryId(Long Category_id) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

}

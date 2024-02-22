package com.cdac_project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cdac_project.exception.MedicineException;
import com.cdac_project.model.Medicine;
import com.cdac_project.model.MedicineCategory;
import com.cdac_project.model.MedicineSearchCriteria;
import com.cdac_project.model.Pharmacist;
import com.cdac_project.repository.MedicineCategoryRepository;
import com.cdac_project.repository.MedicineRepository;
import com.cdac_project.repository.PharmacistRepository;
import com.cdac_project.request.CreateMedicineRequest;

@Service
public class MedicineServiceImplementation implements MedicineService{

	private MedicineRepository medicineRepository;
	private MedicineCategoryRepository categoryRepository; 	
	
	public MedicineServiceImplementation() {}
	
	
	public MedicineServiceImplementation(MedicineRepository medicineRepository,
			MedicineCategoryRepository categoryRepository) {
		super();
		this.medicineRepository = medicineRepository;
		this.categoryRepository = categoryRepository;
	}


	@Override
	public Medicine createMedicine(CreateMedicineRequest req) {
		// TODO Auto-generated method stub
		
		MedicineCategory cid = categoryRepository.findByCategoryid(req.getCategoryid());
		if(cid==null) {
		MedicineCategory category = new MedicineCategory();
		category.setCategoryid((int) 1);
		cid=categoryRepository.save(category);	
		}
		
		Medicine medicine=new Medicine();
		medicine.setName(req.getMedicinename());
		medicine.setCategoryId(cid);
		medicine.setQuantity(req.getMedicineQuantity());
		medicine.setManufactureDate(req.getManufactureDate());
		medicine.setUnitPrice(req.getUnitPrice());
		
		//return medicineRepository.save(medicine);
		//  or
		Medicine savedMedicine = medicineRepository.save(medicine);
		return savedMedicine;
	}

	@Override
	public String deleteMedicine(int Medicine_ID) throws MedicineException {
		 Medicine medicine = findMedicineById(Medicine_ID);
	     medicineRepository.delete(medicine);
	     return "Medicine Deleted Successfully!";
	}

	@Override
	public Medicine updateMedicine(int Medicine_ID, Medicine req) throws MedicineException {
		Medicine medicine= findMedicineById(Medicine_ID);
		if(req.getQuantity()!=0) {
			medicine.setQuantity(req.getQuantity());
		}
		return medicineRepository.save(medicine);
	}

	@Override
	public Medicine findMedicineById(int Medicine_ID) throws MedicineException {
		// TODO Auto-generated method stub
		System.out.println("sddddddddddddddd");
		Optional<Medicine> opt = medicineRepository.findById(Medicine_ID);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new MedicineException("Medicine not Found with ID : "+Medicine_ID);
	}


	@Override
	public List<Medicine> findMedicineByCategory(int Category_id) throws Exception{
		 List<Medicine> medicines = medicineRepository.findAll();
	     List<Medicine> filteredMedicines = medicines.stream()
	                .filter(medicine -> medicine.getCategoryId().getCategoryid() == Category_id)
	                .collect(Collectors.toList());
	        if (!filteredMedicines.isEmpty()) {
	            return filteredMedicines;
	        }
	        throw new MedicineException("Medicine not Found with Category-ID : " + Category_id);
	}


	@Override
	public Page<Medicine> getAllMedicine(int Medicineid, String MedicineName, int CategoryId, int Quantity,
			LocalDate ManufactureDate, int UnitPrice) throws MedicineException {
		// TODO Auto-generated method stub
		 Pageable pageable = PageRequest.of(0, 10); // You can change the page size and number as needed
		 Page<Medicine> medicines = medicineRepository.findAll(pageable);

		    return medicines;
	}


	@Override
	public Page<Medicine> searchMedicines(MedicineSearchCriteria criteria) {
		// TODO Auto-generated method stub
		return medicineRepository.findAll(PageRequest.of(0, 10));
	}

}

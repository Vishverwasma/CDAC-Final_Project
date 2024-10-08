package com.cdac_project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private MedicineRepository medicineRepository;
	@Autowired
	private MedicineCategoryRepository categoryRepository; 	
	
	public MedicineServiceImplementation() {}

	@Override
	public Medicine createMedicine(CreateMedicineRequest req) {


		
		
		 System.out.println("Create Medicine");
		    MedicineCategory category = categoryRepository.findByCategoryid(req.getCategoryid());
            if (category == null) {
		        category = getDefaultCategory();
		    }
		    Medicine medicine = new Medicine();
		    medicine.setName(req.getMedicinename());
		    medicine.setCategoryId(category);
		    medicine.setQuantity(req.getMedicineQuantity());
		    medicine.setManufactureDate(req.getManufactureDate());
		    medicine.setUnitPrice(req.getUnitPrice());
            Medicine savedMedicine = medicineRepository.save(medicine);
		    return savedMedicine;
	}
	
	private MedicineCategory getDefaultCategory() {
	    MedicineCategory defaultCategory = new MedicineCategory();
	    defaultCategory.setCategoryid(1); // Set a default category ID
	    return categoryRepository.save(defaultCategory);
	}

	@Override
	public String deleteMedicine(int Medicine_ID) throws MedicineException {
		System.out.println("Delete Medicine");
		 Medicine medicine = findMedicineById(Medicine_ID);
	     medicineRepository.delete(medicine);
	     return "Medicine Deleted Successfully!";
	}

	@Override
	public Medicine updateMedicine(int Medicine_ID, Medicine req) throws MedicineException {
		System.out.println("Update Medicine");
		Medicine medicine= findMedicineById(Medicine_ID);
		if(req.getQuantity()!=0) {
			medicine.setQuantity(req.getQuantity());
		}
		return medicineRepository.save(medicine);
	}

	@Override
	public Medicine findMedicineById(int Medicine_ID) throws MedicineException {
		// TODO Auto-generated method stub
		System.out.println("find by id");
		Optional<Medicine> medicine=medicineRepository.findById(Medicine_ID);
		return medicine.get();
	}


	@Override
	public List<Medicine> findMedicineByCategory(int Category_id) throws Exception{
		System.out.println("find by Category");
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
		System.out.println("Get All Medicine");
		 Pageable pageable = PageRequest.of(0, 10); // You can change the page size and number as needed
		 Page<Medicine> medicines = medicineRepository.findAll(pageable);

		    return medicines;
	}


	@Override
	public Page<Medicine> searchMedicines(MedicineSearchCriteria criteria) {
		// TODO Auto-generated method stub

		System.out.println("Search Medicine");
		return medicineRepository.findAll(PageRequest.of(0, 10));
	}


	@Override
	public Optional<Medicine> findById(int id) {
        return medicineRepository.findById(id);
	}

	@Override
	public Page<Medicine> getAllMedicines(int page, int size) {
		 Pageable pageable = PageRequest.of(page, size);
	        return medicineRepository.findAll(pageable);
	}

}

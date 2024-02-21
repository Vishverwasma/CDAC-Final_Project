package com.cdac_project.project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cdac_project.project.exception.*;
import com.cdac_project.project.model.Medicine;
import com.cdac_project.project.model.MedicineSearchCriteria;
import com.cdac_project.project.request.CreateMedicineRequest;
import com.cdac_project.project.service.MedicineService;

@RestController
@RequestMapping("/medicine")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicineController {

    private MedicineService medicineService;

	@Autowired
	public MedicineController(MedicineService medicineService) {
		this.medicineService = medicineService;
	}


    @PostMapping("/create")
    public Medicine createMedicine(@RequestBody CreateMedicineRequest req) {
        return medicineService.createMedicine(req);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable("id") int id) throws MedicineException {
        return medicineService.deleteMedicine(id);
    }

    @PutMapping("/update/{id}")
    public Medicine updateMedicine(@PathVariable("id") int id, @RequestBody Medicine req) throws MedicineException {
        return medicineService.updateMedicine(id, req);
    }

    @GetMapping("/get/{id}")
    public Medicine findMedicineById(@PathVariable("id") int id) throws MedicineException {
        return medicineService.findMedicineById(id);
    }

    @GetMapping("/getByCategory/{categoryId}")
    public List<Medicine> findMedicineByCategory(@PathVariable("categoryId") int categoryId) throws Exception {
        return medicineService.findMedicineByCategory(categoryId);
    }

    @GetMapping("/search")
    public Page<Medicine> searchMedicines(
            @RequestParam(required = false) String medicineName,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) LocalDate manufactureDate
    ) throws MedicineException {
        MedicineSearchCriteria criteria = new MedicineSearchCriteria(medicineName, categoryId, quantity, price, manufactureDate);
        return medicineService.searchMedicines(criteria);
    }
}

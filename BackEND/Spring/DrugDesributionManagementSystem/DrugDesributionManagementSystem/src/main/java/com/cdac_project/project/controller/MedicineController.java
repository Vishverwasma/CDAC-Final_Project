package com.cdac_project.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac_project.project.exception.MedicineException;
import com.cdac_project.project.model.Medicine;
import com.cdac_project.project.request.CreateMedicineRequest;
import com.cdac_project.project.service.MedicineService;

@RestController("/api")
public class MedicineController {

	@Autowired
    private MedicineService medicineService;

	public MedicineController(MedicineService medicineService) {
		this.medicineService = medicineService;
	}

	
}

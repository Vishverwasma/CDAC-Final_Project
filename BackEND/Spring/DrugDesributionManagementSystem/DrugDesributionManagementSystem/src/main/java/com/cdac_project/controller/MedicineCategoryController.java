package com.cdac_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac_project.model.MedicineCategory;
import com.cdac_project.service.MedicineCategoryService;

@RestController
@RequestMapping("/categories")
public class MedicineCategoryController {

    @Autowired
    private MedicineCategoryService medicineCategoryService;

    @GetMapping("/all")
    public List<MedicineCategory> getAllCategories() {
        return medicineCategoryService.getAllCategories();
    }
}
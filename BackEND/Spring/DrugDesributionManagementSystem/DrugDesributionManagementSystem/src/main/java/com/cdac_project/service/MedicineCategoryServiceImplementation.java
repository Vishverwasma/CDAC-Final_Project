package com.cdac_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac_project.model.MedicineCategory;
import com.cdac_project.repository.MedicineCategoryRepository;

@Service
public class MedicineCategoryServiceImplementation implements MedicineCategoryService {

    @Autowired
    private MedicineCategoryRepository medicineCategoryRepository;

    @Override
    public List<MedicineCategory> getAllCategories() {
        return medicineCategoryRepository.findAll();
    }
}
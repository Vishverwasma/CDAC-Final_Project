package com.cdac_project.project.model;

import javax.persistence.*;

@Entity
@Table(name="medicine_category")
public class MedicineCategory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Category_id")
    private Long Categoryid;

    @Column(name = "Category_Name")
    private String name;

    @Column(name = "Medicine_Quantity")
    private int MedicineQuantity;
    
    
    
	public MedicineCategory(Long categoryid) {
		super();
		Categoryid = categoryid;
	}

	public int getMedicineQuantity() {
		return MedicineQuantity;
	}

	public void setMedicineQuantity(int medicineQuantity) {
		MedicineQuantity = medicineQuantity;
	}

	public Long getCategoryid() {
		return Categoryid;
	}

	public void setCategoryid(Long Categoryid) {
		this.Categoryid = Categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MedicineCategory(Long Categoryid, String name , int MedicineQuantity) {
		super();
		this.Categoryid = Categoryid;
		this.name = name;
		this.MedicineQuantity = MedicineQuantity;
	}

	public MedicineCategory() {
		super();
	}

    
}

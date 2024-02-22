package com.cdac_project.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="order_medicine")
public class OrderMedicine {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "order_id")
	    private int id;

	    @ManyToOne
	    private Medicine medicine;

	    @JsonIgnore
	    @ManyToOne
	    private Order order;

	    @Column(name = "quantity")
	    private int quantity;

		public OrderMedicine() {
			super();
		}

		public OrderMedicine(int id, Medicine medicine, int quantity) {
			super();
			this.id = id;
			this.medicine = medicine;
			this.quantity = quantity;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		public OrderMedicine(int id, Medicine medicine, Order order, int quantity) {
			super();
			this.id = id;
			this.medicine = medicine;
			this.order = order;
			this.quantity = quantity;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Medicine getMedicine() {
			return medicine;
		}

		public void setMedicine(Medicine medicine) {
			this.medicine = medicine;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}  
	    
    
}

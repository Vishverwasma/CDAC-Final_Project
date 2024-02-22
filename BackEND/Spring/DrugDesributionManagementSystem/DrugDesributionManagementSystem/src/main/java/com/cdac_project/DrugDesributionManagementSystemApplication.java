package com.cdac_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cdac_project.project.*")
public class DrugDesributionManagementSystemApplication {

	public static void main(String[] args) {
		System.out.println("Running");
		SpringApplication.run(DrugDesributionManagementSystemApplication.class, args);
	}

}

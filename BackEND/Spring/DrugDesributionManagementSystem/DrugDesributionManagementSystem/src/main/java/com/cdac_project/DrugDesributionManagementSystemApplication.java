package com.cdac_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan("com.cdac_project.project.*")
public class DrugDesributionManagementSystemApplication {

	public static void main(String[] args) {
		System.out.println("Running");
		SpringApplication.run(DrugDesributionManagementSystemApplication.class, args);
	}

}

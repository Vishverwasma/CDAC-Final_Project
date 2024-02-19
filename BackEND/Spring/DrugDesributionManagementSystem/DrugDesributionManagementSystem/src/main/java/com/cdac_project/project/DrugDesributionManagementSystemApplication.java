package com.cdac_project.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cdac_project.project"}) // Include the package containing Cart class
@EnableJpaRepositories(basePackages = {"com.cdac_project.project.repository"}) // Include the package containing repositories
public class DrugDesributionManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugDesributionManagementSystemApplication.class, args);
	}

}

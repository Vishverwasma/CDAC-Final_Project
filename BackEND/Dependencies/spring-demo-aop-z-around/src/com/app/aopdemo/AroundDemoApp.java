package com.app.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.app.aopdemo.dao.AccountDAO;
import com.app.aopdemo.service.TrafficFortuneService;


public class AroundDemoApp {
	public static void main(String[] args) {
		// read spring config java class
				AnnotationConfigApplicationContext context =
						new AnnotationConfigApplicationContext(DemoConfig.class);
				
				// get the bean from spring container
TrafficFortuneService theTrafficFortune = 
context.getBean("trafficFortuneService", TrafficFortuneService.class);
				
				
				System.out.println("\nMain Program: AroundDemoApp");
				System.out.println("Calling getFortune");
				
				String data = theTrafficFortune.getFortune();
				System.out.println("\nMy Fortune is: "+data);
				
				System.out.println("Finished");
				
				// close the context
				context.close();
			}

}

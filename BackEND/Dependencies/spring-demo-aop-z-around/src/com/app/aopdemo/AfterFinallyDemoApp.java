package com.app.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {
	
	public static void main(String[] args) {
		// read spring config java class
				AnnotationConfigApplicationContext context =
						new AnnotationConfigApplicationContext(DemoConfig.class);
				
				// get the bean from spring container
				AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
				
				//call method to find the accounts
				List<Account> theAccounts = null;
				
				try
				{
					boolean tripWire = true;
					//boolean tripWire = false;
					theAccounts = theAccountDAO.findAccounts(tripWire);					
				}catch (Exception e) {
						// TODO: handle exception
					System.out.println("\n\nMain program... caught exception: "+e);
					
				}
				
				//display the accounts
				System.out.println("\n\nMain program : AfterReturningDemoApp");
				System.out.println("-----");
				System.out.println(theAccounts);
				System.out.println("\n");
								
				// close the context
				context.close();
			}

}

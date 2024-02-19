package com.app.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.app.aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Around("execution(* com.app.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theJoinPoint)throws Throwable
	{
		///print out which method we are advising on
				String method = theJoinPoint.getSignature().toShortString();
				System.out.println("\n=====> executing @Around on method: "+method);	
				
		//get begin timestamp
		long begin = System.currentTimeMillis();	
		System.out.println("Begin = "+begin);
		//now, let's execute the method
		Object result=theJoinPoint.proceed();
		//get end timestamp
		long end = System.currentTimeMillis();
		System.out.println("End  = "+end);
		//compute duration and display it
		long duration = end - begin;
		System.out.println("\n====> Duration to exceute the methdod = "
		+ duration/1000.0 +" seconds");//Convert milliseconds to seconds
	
		return result;
				
		
	}
	
	
	
	
	
	@After("execution(* com.app.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint)
	{
		
		///print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====> executing @After (finally) on method: "+method);	
	}

	
	@AfterThrowing(pointcut="execution(* com.app.aopdemo.dao.AccountDAO.findAccounts(..))",
					throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc)
	{
		///print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====> executing @AfterThrowing on method: "+method);
		
		//log the Exception
		System.out.println("\n======> The Exception is: "+theExc);
		
		
	}
	
	//add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* com.app.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result)
	{
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====> executing @AfterReturning on method: "+method);
		
		//print out the results of the method call
		System.out.println("\n=====> result is: "+result);
	}
	
	
	@Before("execution(* com.app.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void beforeFinallyFindAccountsAdvice(JoinPoint theJoinPoint)
	{
		
		///print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====> executing @Befor on method: "+method);
		
		
		
	}
	

}











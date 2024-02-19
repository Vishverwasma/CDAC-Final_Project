package com.app.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune()
	{
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);//sleep for 5sec
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return a fortune
		return "Expect hevay traffic this morning";
	}

}

package com.app.aopdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.app.aopdemo.service.TrafficFortuneService;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.app.aopdemo")
public class DemoConfig {
	
	/*
	 * @Bean(name="trafficFortuneService") public TrafficFortuneService
	 * getTrafficServrice() { return new TrafficFortuneService(); }
	 */
	

}

package com.cdac_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapTest {

	@RequestMapping("/test")
	@ResponseBody
	public String Test() {
		System.out.println("\"This is a Test ! \"");
		return "This is a Test ! ";
	}
}

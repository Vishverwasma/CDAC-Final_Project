package com.cdac_project.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MapTest {

	@RequestMapping("/test")
	@ResponseBody
	public String Test() {
		System.out.println("\"This is a Test ! \"");
		return "This is a Test ! ";
	}
}

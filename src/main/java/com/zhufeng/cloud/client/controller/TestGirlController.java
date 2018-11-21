package com.zhufeng.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhufeng.cloud.client.config.GirlConfig;

@RestController
@RequestMapping("/girl")
public class TestGirlController {
	@Autowired
	private GirlConfig girlConfig;
	
	@GetMapping("/girlInfo")
	public String girlInfo() {
		return "girl name: " + girlConfig.getName() + ", age: " + girlConfig.getAge();
	}
}

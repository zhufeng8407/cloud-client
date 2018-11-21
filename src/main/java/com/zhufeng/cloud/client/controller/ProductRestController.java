package com.zhufeng.cloud.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class ProductRestController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProductInterface productInterface;
	
	@GetMapping("/restList")
	public String productList() {
		return restTemplate.getForObject("http://PRODUCT/getProductList", String.class);
	}
	
	
	@PostMapping("/feignList/{temp}")
	public String feignList(@PathVariable("temp") String temp) throws InterruptedException {
		log.debug("feignList: " + temp);
		return productInterface.productList(temp);
	}
}

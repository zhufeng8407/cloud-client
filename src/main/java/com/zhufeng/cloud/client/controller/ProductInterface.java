package com.zhufeng.cloud.client.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import feign.hystrix.FallbackFactory;

@FeignClient(value = "product", fallbackFactory = ProductInterface.ProductFallBackController.class)
public interface ProductInterface {

	@RequestMapping(value = "/getProductList", method = RequestMethod.POST)
	public String productList(@RequestParam("temp") String temp);

	@Component
	static class ProductFallBackController implements FallbackFactory<ProductInterface> {

		@Override
		public ProductInterface create(Throwable cause) {
			return new ProductInterface() {

				@Override
				public String productList(String temp) {
					return "fallback; reason was: ";
				}
			};

		}

	}
}

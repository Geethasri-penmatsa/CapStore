package com.cg.capstoreapp.controller;





import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capstoreapp.beans.OrderBean;

@RestController
public class RestConsumer {
	@RequestMapping(value="/")
	public String wel() {
		return "admin";
	}
	@RequestMapping("/getdetails")
	public ModelAndView getTransaction(String orderId,String paymentMethod) {
		System.out.println("***********"+orderId+"*******"+paymentMethod);
		ModelAndView mav = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("orderId", orderId);
		map.add("paymentMethod", paymentMethod);
		System.out.println(map);
		OrderBean response = restTemplate.postForObject("http://localhost:9898/gettransaction?", map,OrderBean.class);
		mav.addObject("customer", response);
		mav.setViewName("getdetails");
		return mav;
	}
	@RequestMapping("/getTransactionalDetails")
	public ModelAndView getTransactionDetails(String orderId) {
		System.out.println("***********"+orderId);
		ModelAndView mav1 = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();
	
	
		OrderBean response = restTemplate.getForObject("http://localhost:9898/gettransactionDetails?orderId="+orderId, OrderBean.class);
		mav1.addObject("customer", response);
		System.out.println(response);
		mav1.setViewName("getTransactionalDetails");
		return mav1;
	}
}

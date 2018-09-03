package com.cg.capstoreapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class JspController {

	@RequestMapping(value="/payment")
	public String wel() {
		return "payment";
	}
	@RequestMapping(value="/pay")
	public String payy() {
		return "pay";
	}
}

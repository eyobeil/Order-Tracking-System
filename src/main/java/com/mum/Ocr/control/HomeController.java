package com.mum.Ocr.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
@RequestMapping(value="/", method=RequestMethod.GET)
public String homeController() {
	return "home/index";
}

@RequestMapping(value="/customerPage", method=RequestMethod.GET)
public String CustomerController() {
	return "home/Customer";
}

@RequestMapping(value="/admin")
public String adminController() {
	return "home/Admin";
}

}

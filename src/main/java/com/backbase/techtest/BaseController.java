package com.backbase.techtest;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BaseController {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public @ResponseBody Person getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		Person emp = new Person();
		emp.setAge(26);
		emp.setName("Dummy");
		return emp;
	}
}

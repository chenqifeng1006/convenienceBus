package com.cc.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.base.BaseController;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
	@ResponseBody
	public void addAdmin() throws Exception {
		
		
	}

}







package com.cc.admin.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.admin.dto.Admin;
import com.cc.admin.service.AdminService;
import com.utils.json.JsonData;

@Controller
@RequestMapping("admin")
public class AdminController /*extends BaseController*/ {
	
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public List<Admin> query() throws Exception {
		
		return this.adminService.query();
	}
	
	/**
	 * 新增管理员
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public JsonData addAdmin() throws Exception {
		Admin admin = new Admin();
		admin.setCellPhone("11111111111");
		admin.setCard("2222222222");
		admin.setPassword("333333333");
		admin.setRegisterTime(new Date());
		admin.setUsername("chenqifeng");
		admin.setRole("123123");
		this.adminService.add(admin);
		return new JsonData(admin);
	}

}







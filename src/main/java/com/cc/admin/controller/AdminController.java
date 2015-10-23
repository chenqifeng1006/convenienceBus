package com.cc.admin.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.admin.dto.Admin;
import com.cc.admin.enums.AdminRole;
import com.cc.admin.service.AdminService;
import com.cc.base.BaseController;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject query() throws Exception {
		
		return new JsonData(this.adminService.query());
	}
	
	/**
	 * 新增管理员
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject add(@Validated Admin admin) throws Exception {
		admin.setRegisterTime(new Date());
		this.adminService.add(admin);
		return new JsonData(admin);
	}
	
	/**
	 * 编辑管理员
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject edit(@Validated Admin admin) throws Exception {
		admin.setRegisterTime(new Date());
		this.adminService.edit(admin);
		return new JsonData(admin);
	}
	
	/**
	 * 编辑管理员
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject delete(@RequestParam(value = "id") Long id) throws Exception {
		Admin admin = this.adminService.getById(id);
		if(admin == null){
			throw new Exception("管理员信息有误，请重试");
		}else if(admin.getRole().equals(AdminRole.superAdmin.toString())){
			throw new Exception("超级管理员不可删除");
		}
		this.adminService.delete(id);
		return new JsonSuccess();
	}

}







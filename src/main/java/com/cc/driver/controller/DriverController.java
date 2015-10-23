package com.cc.driver.controller;

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
import com.cc.base.BaseController;
import com.cc.driver.dto.Driver;
import com.cc.driver.service.DriverService;
import com.utils.json.JsonData;
import com.utils.json.JsonObject;
import com.utils.json.JsonSuccess;

@Controller
@RequestMapping("driver")
public class DriverController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(DriverController.class);
	
	@Autowired
	private DriverService driverService;
	
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonObject query() throws Exception {
		
		return new JsonData(this.driverService.query());
	}
	
	/**
	 * 新增管理员
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject add(@Validated Driver driver) throws Exception {
		driver.setRegisterTime(new Date());
		this.driverService.add(driver);
		return new JsonData(driver);
	}
	
	/**
	 * 编辑管理员
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject edit(@Validated Driver driver) throws Exception {
		this.driverService.edit(driver);
		return new JsonData(driver);
	}
	
	/**
	 * 编辑管理员
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonObject delete(@RequestParam(value = "id") Long id) throws Exception {
		Driver driver = this.driverService.getById(id);
		if(driver == null){
			throw new Exception("管理员信息有误，请重试");
		}
		this.driverService.delete(id);
		return new JsonSuccess();
	}

}







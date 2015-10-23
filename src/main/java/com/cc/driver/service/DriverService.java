package com.cc.driver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.driver.dao.DriverMapper;
import com.cc.driver.dto.Driver;

@Service
public class DriverService {
	
	@Autowired
	private DriverMapper driverMapper;
	
	public List<Driver> query(){
		return this.driverMapper.query();
	}
	
	public Driver getById(Long id){
		return this.driverMapper.getById(id);
	}
	
	public void add(Driver driver){
		this.driverMapper.add(driver);
	}
	
	public void edit(Driver driver){
		this.driverMapper.edit(driver);
	}
	
	public void delete(Long id){
		this.driverMapper.delete(id);
	}
}
